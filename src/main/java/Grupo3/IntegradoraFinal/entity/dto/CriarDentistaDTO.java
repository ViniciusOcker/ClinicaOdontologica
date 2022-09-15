package Grupo3.IntegradoraFinal.entity.dto;

import java.io.Serializable;

public class CriarDentistaDTO implements Serializable {
    private String nome;
    private String sobrenome;
    private String cro;

    public CriarDentistaDTO(String nome, String sobrenome, String cro) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
    }

    public CriarDentistaDTO() {
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
}
