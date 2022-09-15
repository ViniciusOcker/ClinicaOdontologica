package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.UsuarioEntity;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
    private Long idUsuario;
    private String nomeDeUsuario;
    private String senha;
    private Boolean admin;

    public UsuarioDTO(Long idUsuario, String nomeDeUsuario, String senha, Boolean admin) {
        this.idUsuario = idUsuario;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.admin = admin;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuarioEntity) {
        this.idUsuario = usuarioEntity.getIdUsuario();
        this.nomeDeUsuario = usuarioEntity.getNomeDeUsuario();
        this.senha = usuarioEntity.getSenha();
        this.admin = usuarioEntity.getAdmin();
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
