package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import java.time.LocalDateTime;

public class ConsultaDTO {
    private Long id;
    private PacienteEntity paciente;
    private FuncionarioEntity funcionario;
    private LocalDateTime inicioConsulta;
    private LocalDateTime fimConsulta;

    public ConsultaDTO(Long id, PacienteEntity paciente, FuncionarioEntity funcionario, LocalDateTime inicioConsulta, LocalDateTime fimConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.funcionario = funcionario;
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

    public FuncionarioEntity getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioEntity funcionario) {
        this.funcionario = funcionario;
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

    @Override
    public String toString() {
        return "ConsultaDTO{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", funcionario=" + funcionario +
                ", inicioConsulta=" + inicioConsulta +
                ", fimConsulta=" + fimConsulta +
                '}';
    }
}
