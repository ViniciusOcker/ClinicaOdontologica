package Grupo3.IntegradoraFinal.entity.dto;

public class CriarFuncionarioDTO {

    private String nomeDeUsuario;
    private String senha;
    private String nome;
    private String sobrenome;
    private String cro;
    private boolean admin;

    public CriarFuncionarioDTO(String nomeDeUsuario, String senha, String nome, String sobrenome, String cro, boolean admin) {
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.admin = admin;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
