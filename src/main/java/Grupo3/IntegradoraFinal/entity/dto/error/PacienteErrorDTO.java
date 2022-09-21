package Grupo3.IntegradoraFinal.entity.dto.error;

import Grupo3.IntegradoraFinal.entity.dto.CriarEnderecoDTO;

public class PacienteErrorDTO {
    private String nome;
    private String sobrenome;
    private String endereco;
    private String rg;
    private String dataDeAlta;

    public PacienteErrorDTO(String nome, String sobrenome, String endereco, String rg, String dataDeAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }

    public PacienteErrorDTO() {
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
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
