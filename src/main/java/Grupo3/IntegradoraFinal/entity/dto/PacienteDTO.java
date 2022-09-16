package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.PacienteEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PacienteDTO implements Serializable {
    private Long idPaciente;
    private String nome;
    private String sobrenome;
    private EnderecoDTO endereco;
    private String rg;
    private String dataDeAlta;

    public PacienteDTO(Long idPaciente, String nome, String sobrenome, EnderecoDTO endereco, String rg, String dataDeAlta) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
    }

    public PacienteDTO() {
    }

    public PacienteDTO(PacienteEntity pacienteEntity) {
        this.idPaciente = pacienteEntity.getIdPaciente();
        this.nome = pacienteEntity.getNome();
        this.sobrenome = pacienteEntity.getSobrenome();
        this.endereco = new EnderecoDTO(pacienteEntity.getEndereco());
        this.rg = pacienteEntity.getRg();
        this.dataDeAlta = pacienteEntity.getDataDeAlta();
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
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