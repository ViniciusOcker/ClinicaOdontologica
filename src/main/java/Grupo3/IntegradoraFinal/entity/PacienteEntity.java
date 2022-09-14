package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarPacienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Entity
@Table(name = "Paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Long idPaciente;
    private String nome;
    private String sobrenome;

    @OneToOne
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
    private EnderecoEntity endereco;
    @Column(nullable = false)
    private String rg;
    private LocalDate dataDeAlta;
    @OneToMany(mappedBy = "id")
    private Set<ConsultaEntity> consultas;

    public PacienteEntity(Long idPaciente, String nome, String sobrenome, EnderecoEntity endereco, String rg, LocalDate dataDeAlta, Set<Grupo3.IntegradoraFinal.entity.ConsultaEntity> consultas) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
        this.consultas = consultas;
    }

    public PacienteEntity() {
    }

    public PacienteEntity(CriarPacienteDTO criarPacienteDTO, Long id) {
        this.nome = criarPacienteDTO.getNome();
        this.sobrenome = criarPacienteDTO.getSobrenome();
        this.endereco = new EnderecoEntity(id);
        this.rg = criarPacienteDTO.getRg();
        this.dataDeAlta = null;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getDataDeAlta() {
        return dataDeAlta;
    }

    public void setDataDeAlta(LocalDate dataDeAlta) {
        this.dataDeAlta = dataDeAlta;
    }

    public Set<Grupo3.IntegradoraFinal.entity.ConsultaEntity> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Grupo3.IntegradoraFinal.entity.ConsultaEntity> consultas) {
        this.consultas = consultas;
    }
}