package Grupo3.IntegradoraFinal.entity.dto;

import java.io.Serializable;

public class CriarUsuarioDTO implements Serializable {
    private String nomeDeUsuario;
    private String senha;
    private Boolean admin;

    public CriarUsuarioDTO(String nomeDeUsuario, String senha, Boolean admin) {
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.admin = admin;
    }

    public CriarUsuarioDTO() {
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
