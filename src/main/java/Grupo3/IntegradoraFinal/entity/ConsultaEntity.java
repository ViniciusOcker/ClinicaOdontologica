package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "consulta")
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
    @Column(nullable = false)
    private LocalDateTime inicioConsulta;
    @Column(nullable = false)
    private LocalDateTime fimConsulta;

    public ConsultaEntity(Long idConsulta, PacienteEntity paciente, DentistaEntity dentista, String inicioConsulta, String fimConsulta) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.dentista = dentista;
        this.inicioConsulta = LocalDateTime.parse(inicioConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.fimConsulta = LocalDateTime.parse(fimConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public ConsultaEntity() {
    }

    public ConsultaEntity(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public ConsultaEntity(CriarConsultaDTO criarConsultaDTO) {
        this.paciente = new PacienteEntity(criarConsultaDTO.getIdPaciente());
        this.dentista = new DentistaEntity(criarConsultaDTO.getIdDentista());
        this.inicioConsulta = LocalDateTime.parse(criarConsultaDTO.getInicioConsulta(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        this.fimConsulta = LocalDateTime.parse(criarConsultaDTO.getFimConsulta(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
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

    public String getInicioConsulta() {
        return this.inicioConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public void setInicioConsulta(String inicioConsulta) {
        this.inicioConsulta = LocalDateTime.parse(inicioConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getFimConsulta() {
        return this.fimConsulta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public void setFimConsulta(String fimConsulta) {
        this.fimConsulta = LocalDateTime.parse(fimConsulta, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
}
