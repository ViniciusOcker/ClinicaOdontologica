package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String rg;
    @Column
    private LocalDate data_de_alta;

    public PacienteEntity(String nome, String sobrenome, String endereco, String rg, LocalDate data_de_alta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.data_de_alta = data_de_alta;
    }

    public PacienteEntity(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.getNomeCompleto();
        this.endereco = pacienteDTO.getEndereco();
        this.rg = pacienteDTO.getRg();
        this.data_de_alta = pacienteDTO.getData_de_alta();
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

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
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
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", rg='" + rg + '\'' +
                ", data_de_alta=" + data_de_alta +
                '}';
    }
}