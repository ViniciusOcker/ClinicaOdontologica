package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;

public class FuncionarioDTO {


    private String nomeCompleto;
    private Integer cro;

    public FuncionarioDTO(FuncionarioEntity funcionario) {
        this.nomeCompleto = funcionario.getNome() + " " + funcionario.getSobrenome();
        this.cro = funcionario.getCro();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Integer getCro() {
        return cro;
    }
    public void setCro(Integer cro) {
        this.cro = cro;
    }
}
