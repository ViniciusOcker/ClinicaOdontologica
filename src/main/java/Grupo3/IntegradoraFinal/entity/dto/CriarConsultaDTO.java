package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CriarConsultaDTO implements Serializable {
    private Long idPaciente;
    private Long idDentista;
    private String inicioConsulta;
    private String fimConsulta;

    public CriarConsultaDTO(Long idPaciente, Long idDentista, String inicioConsulta, String fimConsulta) {
        this.idPaciente = idPaciente;
        this.idDentista = idDentista;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    public CriarConsultaDTO() {}

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

    public String getInicioConsulta() {
        return inicioConsulta;
    }

    public void setInicioConsulta(String inicioConsulta) {
        this.inicioConsulta = inicioConsulta;
    }

    public String getFimConsulta() {
        return fimConsulta;
    }

    public void setFimConsulta(String fimConsulta) {
        this.fimConsulta = fimConsulta;
    }
}
