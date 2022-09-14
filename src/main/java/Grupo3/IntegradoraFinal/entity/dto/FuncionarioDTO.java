package Grupo3.IntegradoraFinal.entity.dto;

import java.io.Serializable;

public class FuncionarioDTO implements Serializable {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cro;
    private boolean admin;

    public FuncionarioDTO(Long id, String nome, String sobrenome, String cro, boolean admin) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.admin = admin;
    }

    public FuncionarioDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "FuncionarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cro=" + cro +
                ", admin=" + admin +
                '}';
    }
}
