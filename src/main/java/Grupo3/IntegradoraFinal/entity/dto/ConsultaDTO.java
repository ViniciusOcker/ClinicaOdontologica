package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ConsultaDTO implements Serializable {
    private Long idConsulta;
    private Long idPaciente;
    private Long idDentista;
    private LocalDateTime inicioConsulta;
    private LocalDateTime fimConsulta;

    public ConsultaDTO(Long idConsulta, Long idPaciente, Long idDentista, LocalDateTime inicioConsulta, LocalDateTime fimConsulta) {
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
