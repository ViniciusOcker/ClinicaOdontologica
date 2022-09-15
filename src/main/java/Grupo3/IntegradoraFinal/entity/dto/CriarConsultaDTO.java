package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CriarConsultaDTO implements Serializable {
    private Long idPaciente;
    private Long idDentista;
    private LocalDateTime inicioConsulta;
    private LocalDateTime fimConsulta;

    public CriarConsultaDTO(Long idPaciente, Long idDentista, LocalDateTime inicioConsulta, LocalDateTime fimConsulta) {
        this.idPaciente = idPaciente;
        this.idDentista = idDentista;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    public CriarConsultaDTO() {
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Long idDentista) {
        this.idDentista = idDentista;
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
