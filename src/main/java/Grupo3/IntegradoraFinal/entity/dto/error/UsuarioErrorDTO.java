package Grupo3.IntegradoraFinal.entity.dto.error;

import java.io.Serializable;

public class UsuarioErrorDTO implements Serializable {
   private String nomeUsuario;
   private String senha;
   private String role;

    public UsuarioErrorDTO(String nomeUsuario, String senha, String role) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.role = role;
    }

    public UsuarioErrorDTO() {
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
