package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.PacienteEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacienteDTO {

    private String nomeCompleto;

    private String endereco;
    private String rg;
    private LocalDate data_de_alta;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PacienteDTO(PacienteEntity paciente) {
        this.nomeCompleto = paciente.getNome() + " " + paciente.getSobrenome();
        this.endereco = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.data_de_alta = paciente.getData_de_alta();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }
}