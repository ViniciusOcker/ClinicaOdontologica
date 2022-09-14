package Grupo3.IntegradoraFinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsulta")
    private Long id;
    @ManyToOne
    @JoinColumn(name="idPaciente", nullable=false)

    private PacienteEntity paciente;
    @ManyToOne
    @JoinColumn(name="idFuncionario", nullable=false)

    private FuncionarioEntity funcionario;
    @Column(unique = true, nullable = false)
    private LocalDateTime inicioConsulta;
    @Column(unique = true, nullable = false)
    private LocalDateTime fimConsulta;

    public ConsultaEntity(Long id, PacienteEntity paciente, FuncionarioEntity funcionario, LocalDateTime inicioConsulta, LocalDateTime fimConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.funcionario = funcionario;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    public ConsultaEntity() {
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
        return "ConsultaEntity{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", funcionario=" + funcionario +
                ", inicioConsulta=" + inicioConsulta +
                ", fimConsulta=" + fimConsulta +
                '}';
    }
}
