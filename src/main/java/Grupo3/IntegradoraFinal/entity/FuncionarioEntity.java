package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;

import javax.persistence.*;

@Entity
@Table(name = "Funcionario")
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario")
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    private Integer cro;
    private boolean admin;

    private UsuarioEntity usuario;

    public FuncionarioEntity(Integer id, String nome, String sobrenome, Integer cro, boolean admin, UsuarioEntity usuario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.admin = admin;
        this.usuario = usuario;
    }

    public FuncionarioEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCro() {
        return cro;
    }

    public void setCro(Integer cro) {
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

    @Override
    public String toString() {
        return "FuncionarioEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cro=" + cro +
                ", admin=" + admin +
                '}';
    }
}
