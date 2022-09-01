package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;

public class FuncionarioEntity {
    private Integer id;
    private String nome;
    private String sobrenome;
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
        this.nome = funcionarioDTO.getNome();
        this.sobrenome = funcionarioDTO.getSobrenome();
        this.cro = funcionarioDTO.getCro();
    }
}
