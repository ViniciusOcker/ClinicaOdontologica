package Grupo3.IntegradoraFinal.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Paciente")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private EnderecoEntity endereco;
    @Column(nullable = false)
    private String rg;
    private LocalDate data_de_alta;
    private UsuarioEntity usuario;

    PacienteEntity(String nome, String sobrenome, EnderecoEntity endereco,UsuarioEntity usuario, String rg, LocalDate data_de_alta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.usuario = usuario;
        this.rg = rg;
        this.data_de_alta = data_de_alta;
    }

    public PacienteEntity() {
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

    public LocalDate getData_de_alta() {
        return data_de_alta;
    }
    public void setData_de_alta(LocalDate data_de_alta) {
        this.data_de_alta = data_de_alta;
    }

    @Override
    public String toString() {
        return "PacienteEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco=" + endereco +
                ", rg='" + rg + '\'' +
                ", data_de_alta=" + data_de_alta +
                ", usuario=" + usuario +
                '}';
    }
}
