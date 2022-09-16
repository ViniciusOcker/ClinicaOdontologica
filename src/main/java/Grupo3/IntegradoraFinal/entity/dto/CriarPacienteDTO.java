package Grupo3.IntegradoraFinal.entity.dto;

import java.io.Serializable;

public class CriarPacienteDTO implements Serializable {

    private String nome;
    private String sobrenome;
    private CriarEnderecoDTO endereco;
    private String rg;
    private String dataDeAlta;

    public CriarPacienteDTO(String nome, String sobrenome, CriarEnderecoDTO endereco, String rg, String dataDeAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
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

    public CriarEnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(CriarEnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(String dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }
}
