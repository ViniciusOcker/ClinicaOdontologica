package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.Funcionario;

public class FuncionarioDTO {

    private String nome;
    private String sobrenome;
    private Integer cro;

    public FuncionarioDTO(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.sobrenome = funcionario.getSobrenome();
        this.cro = funcionario.getCro();
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
}
