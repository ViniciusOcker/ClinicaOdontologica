package Grupo3.IntegradoraFinal.validation;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarPacienteDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.DentistaErrorDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.PacienteErrorDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PacienteValidation {
    private static final String nomeSobrenomeRegexp = "^[A-Za-z0-9áéíóúÁÉÍÓÚàèìòùÀÈÌÒÙâêîôûÂÊÎÔÛãẽĩõũÃẼĨÕŨçÇ ]{1,}$";
    private static final String croRegexp = "^[0-9]{1,}\\/[A-Z]{2}$";
    private static final String rgRegexp = "^[0-9]{1,}\\/[A-Za-z]{1,}\\/[A-Z]{2}$";

    private static final String dataRegexp = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4} [0-9]{2}:[0-9]{2}:[0-9]{2}$";
    public PacienteValidation() {
    }
    
    public PacienteErrorDTO validation(CriarPacienteDTO criarPacienteDTO){
        return new PacienteErrorDTO(validationNomeSobrenome(criarPacienteDTO.getNome()), validationNomeSobrenome(criarPacienteDTO.getSobrenome()), null, validationRG(criarPacienteDTO.getRg()), validationData(criarPacienteDTO.getDataDeAlta()));
    }

    public String validationData(String data){
        if(!data.trim().isEmpty()){
            if(!Evalido(data, dataRegexp)){
                return "A data está do formato incorreto![Formato correto: dd/MM/yyyy HH:mm:ss]";
            }
        }
        return null;
    }

    public String validationRG(String rg){
        if (rg.trim().isBlank()){
            return "Este atribuito não pode ser vazio";
        }
        else if(!Evalido(rg, rgRegexp)){
            return "O RG está do formato incorreto!";
        }
        return null;
    }

    public String validationNomeSobrenome(String nome){
        if (nome.trim().isBlank()){
            return "Este atribuito não pode ser vazio";
        }
        else if(!validationLength(nome.trim().split(" "), 2)){
            return "Este atribuito contém palavras menor do que 2 caractres";
        }
        else if(!Evalido(nome, nomeSobrenomeRegexp)){
            return "Este atribuito contém caracteres invalidos!";
        }
        return null;
    }
    private boolean validationLength(String[] lista, int min){
        boolean tmp = true;
        for (String item: lista) {
            if(item.length() < min){
                tmp = false;
            }
        }
        return tmp;
    }
    public boolean Evalido(String texto, String regexp){
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }

    public String getRegexpText(){
        return this.nomeSobrenomeRegexp;
    }
}
