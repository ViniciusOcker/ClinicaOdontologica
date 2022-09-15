package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ConsultaDTO implements Serializable {
    private Long id;
    private Long idPaciente;
    private Long idDentista;
    private LocalDateTime inicioConsulta;
    private LocalDateTime fimConsulta;

    public ConsultaDTO(Long id, Long idPaciente, Long idDentista, LocalDateTime inicioConsulta, LocalDateTime fimConsulta) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idDentista = idDentista;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    public ConsultaDTO() {
    }

    public ConsultaDTO(ConsultaEntity consultaEntity) {
        this.id = consultaEntity.getIdConsulta();
        this.idPaciente = consultaEntity.getPaciente().getIdPaciente();
        this.idDentista = consultaEntity.getDentista().getIdDentista();
        this.inicioConsulta = consultaEntity.getInicioConsulta();
        this.fimConsulta = consultaEntity.getFimConsulta();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
