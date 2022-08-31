package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.Paciente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacienteDTO {

    private String nome;
    private String sobrenome;
    private String endereco;
    private String rg;
    private LocalDate data_de_alta;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PacienteDTO(Paciente paciente) {
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.endereco = paciente.getEndereco();
        this.rg = paciente.getRg();
        this.data_de_alta = paciente.getData_de_alta();
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

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }
}
