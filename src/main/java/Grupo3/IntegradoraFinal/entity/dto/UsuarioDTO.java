package Grupo3.IntegradoraFinal.entity.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private Long id;
    private String nomeDeUsuario;
    private String senha;
    private boolean admin;

    public UsuarioDTO(Long id, String nomeDeUsuario, String senha, boolean admin) {
        this.id = id;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.admin = admin;
    }

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
