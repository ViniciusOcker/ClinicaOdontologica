package Grupo3.IntegradoraFinal.validation;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.DentistaErrorDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.UsuarioErrorDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DentistaValidation {
    private static final String nomeSobrenomeRegexp = "^[A-Za-z0-9áéíóúÁÉÍÓÚàèìòùÀÈÌÒÙâêîôûÂÊÎÔÛãẽĩõũÃẼĨÕŨçÇ ]{1,}$";
    private static final String croRegexp = "^[0-9]{1,}\\/[A-Z]{2}$";

    public DentistaValidation() {
    }
    
    public DentistaErrorDTO validation(CriarDentistaDTO criarDentistaDTO){
        return new DentistaErrorDTO(validationNomeSobrenome(criarDentistaDTO.getNome()),validationNomeSobrenome(criarDentistaDTO.getSobrenome()),validationCRO(criarDentistaDTO.getCro()));
    }

    public String validationCRO(String cro){
        if (cro.trim().isBlank()){
            return "Este atribuito não pode ser vazio";
        }
        else if(!Evalido(cro, croRegexp)){
            return "Este atribuito está do formato invalido";
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
