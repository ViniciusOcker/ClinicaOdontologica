package Grupo3.IntegradoraFinal.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "Paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public PacienteEntity(Integer id, String nome, String sobrenome, EnderecoEntity endereco, String rg, LocalDate dataDeAlta, UsuarioEntity usuario, Set<ConsultaEntity> consultas) {
        this.id = id;
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
                "id=" + id +
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