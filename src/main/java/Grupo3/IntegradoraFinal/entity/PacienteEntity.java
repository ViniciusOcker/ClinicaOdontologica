package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarPacienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "Paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Long idPaciente;
    private String nome;
    private String sobrenome;
    @Column(unique = true, nullable = false)
    @JoinColumn(name = "idEndereco", referencedColumnName = "idEndereco")
    private EnderecoEntity endereco;
    @Column(nullable = false)
    private String rg;
    private LocalDate dataDeAlta;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioEntity usuario;
    @OneToMany(mappedBy = "id")
    private Set<ConsultaEntity> consultas;

    public PacienteEntity(Long idPaciente, String nome, String sobrenome, EnderecoEntity endereco, String rg, LocalDate dataDeAlta, UsuarioEntity usuario, Set<ConsultaEntity> consultas) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
        this.usuario = usuario;
        this.consultas = consultas;
    }

    public PacienteEntity() {
    }

    public PacienteEntity(CriarPacienteDTO criarPacienteDTO, Long idUsuario, Long idEndereco) {
        this.nome = criarPacienteDTO.getNome();
        this.sobrenome = criarPacienteDTO.getSobrenome();
        this.endereco = new EnderecoEntity(idEndereco);
        this.rg = criarPacienteDTO.getRg();
        this.usuario = new UsuarioEntity(idUsuario);
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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public Set<ConsultaEntity> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<ConsultaEntity> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "PacienteEntity{" +
                "id=" + idPaciente +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco=" + endereco +
                ", rg='" + rg + '\'' +
                ", dataDeAlta=" + dataDeAlta +
                ", usuario=" + usuario +
                ", consultas=" + consultas +
                '}';
    }
}