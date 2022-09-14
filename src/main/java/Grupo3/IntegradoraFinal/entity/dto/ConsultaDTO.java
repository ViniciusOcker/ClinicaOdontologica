package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ConsultaDTO implements Serializable {
    private Long id;
    private PacienteEntity paciente;
    private DentistaEntity dentista;
    private LocalDateTime inicioConsulta;
    private LocalDateTime fimConsulta;

    public ConsultaDTO(Long id, PacienteEntity paciente, DentistaEntity dentista, LocalDateTime inicioConsulta, LocalDateTime fimConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.dentista = dentista;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    public ConsultaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public DentistaEntity getDentista() {
        return dentista;
    }

    public void setDentista(DentistaEntity dentista) {
        this.dentista = dentista;
    }

    public LocalDateTime getInicioConsulta() {
        return inicioConsulta;
    }

    public void setInicioConsulta(LocalDateTime inicioConsulta) {
        this.inicioConsulta = inicioConsulta;
    }

    public LocalDateTime getFimConsulta() {
        return fimConsulta;
    }

    public void setFimConsulta(LocalDateTime fimConsulta) {
        this.fimConsulta = fimConsulta;
    }
}
