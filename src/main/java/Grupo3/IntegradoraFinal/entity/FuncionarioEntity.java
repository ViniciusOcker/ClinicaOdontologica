package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarFuncionarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Funcionario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario")
    private Long idFuncionario;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(unique = true, nullable = false)
    private String cro;
    private boolean admin;
    @JoinColumn(name= "idUsuario", referencedColumnName = "idUsuario")
    private UsuarioEntity usuario;
    @OneToMany(mappedBy="id")
    private Set<ConsultaEntity> consultas;

    public FuncionarioEntity(Long idFuncionario, String nome, String sobrenome, String cro, boolean admin, UsuarioEntity usuario, Set<ConsultaEntity> consultas) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.admin = admin;
        this.usuario = usuario;
        this.consultas = consultas;
    }

    public FuncionarioEntity() {
    }

    public FuncionarioEntity(CriarFuncionarioDTO criarFuncionarioDTO, Long idUsuario) {
        this.nome = criarFuncionarioDTO.getNome();
        this.sobrenome =criarFuncionarioDTO.getSobrenome();
        this.cro = criarFuncionarioDTO.getCro();
        this.admin = criarFuncionarioDTO.isAdmin();
        this.usuario = new UsuarioEntity(idUsuario);
    }


    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
        return "FuncionarioEntity{" +
                "id=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cro='" + cro + '\'' +
                ", admin=" + admin +
                ", usuario=" + usuario +
                ", consultas=" + consultas +
                '}';
    }
}
