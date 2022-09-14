package Grupo3.IntegradoraFinal.entity.dto;

public class CriarUsuarioDTO {
    private String nomeDeUsuario;
    private String senha;
    private boolean admin;

    public CriarUsuarioDTO(String nomeDeUsuario, String senha, boolean admin) {
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
