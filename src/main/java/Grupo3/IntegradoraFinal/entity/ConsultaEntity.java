package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
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
    private Long idConsulta;
    @ManyToOne
    @JoinColumn(name="idPaciente", nullable=false)

    private PacienteEntity paciente;
    @ManyToOne
    @JoinColumn(name="idDentista", nullable=false)

    private DentistaEntity dentista;
    @Column(unique = true, nullable = false)
    private LocalDateTime inicioConsulta;
    @Column(unique = true, nullable = false)
    private LocalDateTime fimConsulta;

    public ConsultaEntity(Long idConsulta, PacienteEntity paciente, DentistaEntity dentista, LocalDateTime inicioConsulta, LocalDateTime fimConsulta) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.dentista = dentista;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
    }

    public ConsultaEntity() {
    }

    public ConsultaEntity(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public ConsultaEntity(CriarConsultaDTO criarConsultaDTO) {
        this.paciente = new PacienteEntity(criarConsultaDTO.getIdPaciente());
        this.dentista = new DentistaEntity(criarConsultaDTO.getIdDentista());
        this.inicioConsulta = criarConsultaDTO.getInicioConsulta();
        this.fimConsulta = criarConsultaDTO.getFimConsulta();
    }

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
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
