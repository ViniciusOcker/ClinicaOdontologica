package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long id;
    @Column(unique = true, nullable = false)
    private String nomeDeUsuario;
    @Column(nullable = false)
    private String senha;
    @OneToOne(mappedBy = "idPaciente")
    private Set<PacienteEntity> pacientes;

    @OneToOne(mappedBy = "idFuncionario")
    private Set<FuncionarioEntity> funcionarios;

    public UsuarioEntity(Long id, String nomeDeUsuario, String senha, Set<PacienteEntity> pacientes, Set<FuncionarioEntity> funcionarios) {
        this.id = id;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.pacientes = pacientes;
        this.funcionarios = funcionarios;
    }

    public UsuarioEntity() {
    }

    public UsuarioEntity(CriarUsuarioDTO criarUsuarioDTO) {
        this.nomeDeUsuario = criarUsuarioDTO.getNomeDeUsuario();
        this.senha = criarUsuarioDTO.getSenha();
    }

    public UsuarioEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<PacienteEntity> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Set<PacienteEntity> pacientes) {
        this.pacientes = pacientes;
    }

    public Set<FuncionarioEntity> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Set<FuncionarioEntity> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", nomeDeUsuario='" + nomeDeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", pacientes=" + pacientes +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
