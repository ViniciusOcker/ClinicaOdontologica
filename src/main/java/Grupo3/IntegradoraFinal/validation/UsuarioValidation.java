package Grupo3.IntegradoraFinal.validation;

import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.UsuarioErrorDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UsuarioValidation {
    private static final int usuarioCaracterMinimo = 5;
    private static final int usuarioCaracterMaximo = 12;
    private static final String usuarioCaracteresPermitidos = "^([A-Za-z0-9]){1,}$";

    private static final int senhaCaracterMinimo = 8;
    private static final int senhaCaracterMaximo = 60;
    private static final String senhaRegexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$";

    public UsuarioValidation() {
    }
    
    public UsuarioErrorDTO validation(CriarUsuarioDTO criarUsuarioDTO){
        return new UsuarioErrorDTO(validationNomeUsuario(criarUsuarioDTO.getNomeDeUsuario()), validationNomeSenha(criarUsuarioDTO.getSenha()), null);
    }
    public String validationNomeUsuario(String nomeUsuario){
        if (nomeUsuario.trim().isBlank()){
            return "O nome do Usuario não pode ser vazio";
        } else if (nomeUsuario.trim().length() < usuarioCaracterMinimo ){
            return "O numero de Caracter do usuario é inferior do que permitido [Minimo " + usuarioCaracterMinimo + " Caracteres] ";
        } else if (nomeUsuario.trim().length() > usuarioCaracterMaximo) {
            return "O numero de Caracter do usuario é Maior do que permitido [Maximo " + usuarioCaracterMaximo + " Caracteres] ";
        } else if (!Evalido(nomeUsuario, usuarioCaracteresPermitidos)) {
            return "O nome do usuario tem caracteres não Permitidos";
        }
        return null;
    }

    private String validationNomeSenha(String senha){
        if (senha.trim().isBlank()){
            return "A senha não pode ser vazio";
        } else if (senha.trim().length() < senhaCaracterMinimo ){
            return "A senha é inferior do que permitido [Minimo " + usuarioCaracterMinimo + " Caracteres] ";
        } else if (senha.trim().length() > senhaCaracterMaximo) {
            return "A senha é Maior do que permitido [Maximo " + senhaCaracterMaximo + " Caracteres] ";
        } else if (!Evalido(senha, senhaRegexp)) {
            return "Infelizmente sua senha não corresponde ao permitido";
        }
        return null;
    }

     public boolean Evalido(String texto, String regexp){
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }
}
