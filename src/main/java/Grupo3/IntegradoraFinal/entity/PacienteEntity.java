package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;

import java.time.LocalDate;

public class PacienteEntity {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String rg;
    private LocalDate data_de_alta;

    public PacienteEntity(String nome, String sobrenome, String endereco, String rg, LocalDate data_de_alta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.data_de_alta = data_de_alta;
    }

    public PacienteEntity(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.endereco = pacienteDTO.getEndereco();
        this.rg = pacienteDTO.getRg();
        this.data_de_alta = pacienteDTO.getData_de_alta();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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

    public LocalDate getData_de_alta() {
        return data_de_alta;
    }
    public void setData_de_alta(LocalDate data_de_alta) {
        this.data_de_alta = data_de_alta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", rg='" + rg + '\'' +
                ", data_de_alta=" + data_de_alta +
                '}';
    }
}
