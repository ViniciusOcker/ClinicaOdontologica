package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
public class FuncionarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String sobrenome;
    @Column(unique = true, nullable = false)
    private Integer cro;

    public Integer getCro() {
        return cro;
    }
    public void setCro(Integer cro) {
        this.cro = cro;
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

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public FuncionarioEntity() {
    }

    public FuncionarioEntity(FuncionarioDTO funcionarioDTO) {
        this.nome = funcionarioDTO.getNomeCompleto();
        this.cro = funcionarioDTO.getCro();
    }
}
