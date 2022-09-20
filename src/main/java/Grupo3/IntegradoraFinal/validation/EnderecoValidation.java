package Grupo3.IntegradoraFinal.validation;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarEnderecoDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.DentistaErrorDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.EnderecoErrorDTO;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EnderecoValidation {
    private static final String textRegexp = "^[A-Za-z0-9áéíóúÁÉÍÓÚàèìòùÀÈÌÒÙâêîôûÂÊÎÔÛãẽĩõũÃẼĨÕŨçÇ.- ]{1,}$";

    public EnderecoValidation() {
    }
    
    public EnderecoErrorDTO validation(CriarEnderecoDTO criarEnderecoDTO){
        return new EnderecoErrorDTO(validationText(criarEnderecoDTO.getComplemento()), validationText(criarEnderecoDTO.getRua()), validationNumero(criarEnderecoDTO.getNumero()), validationText(criarEnderecoDTO.getBairro()), validationText(criarEnderecoDTO.getCidade()), validationText(criarEnderecoDTO.getEstado()), validationText(criarEnderecoDTO.getPontoDeReferencia()));
    }

    public String validationNumero(String numero){
        if (numero.trim().isBlank()){
            return "Este atribuito não pode ser vazio";
        } else if (!Evalido(numero, "^[0-9]{1,}[A-Z]{0,1}$")) {
            if(!numero.equals("SN")){
                return "O formato do número é invalido";
            }
        }
        return null;
    }
    
    public String validationText(String texto){
        if (texto.trim().isBlank()){
            return "Este atribuito não pode ser vazio";
        }
        else if(!Evalido(texto, textRegexp)){
            return "Este atribuito contém caracteres invalidos!";
        }
        return null;
    }
    public boolean Evalido(String texto, String regexp){
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }
}
