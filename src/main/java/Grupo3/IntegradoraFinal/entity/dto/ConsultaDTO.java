package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsultaDTO implements Serializable {
    private Long idConsulta;
    private Long idPaciente;
    private Long idDentista;
    private String inicioConsulta;
    private String fimConsulta;

    public ConsultaDTO(Long idConsulta, Long idPaciente, Long idDentista, String inicioConsulta, String fimConsulta) {
        this.idConsulta = idConsulta;
        this.idPaciente = idPaciente;
        this.idDentista = idDentista;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    public ConsultaDTO() {
    }

    public ConsultaDTO(ConsultaEntity consultaEntity) {
        this.idConsulta = consultaEntity.getIdConsulta();
        this.idPaciente = consultaEntity.getPaciente().getIdPaciente();
        this.idDentista = consultaEntity.getDentista().getIdDentista();
        this.inicioConsulta = consultaEntity.getInicioConsulta();
        this.fimConsulta = consultaEntity.getFimConsulta();
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
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
