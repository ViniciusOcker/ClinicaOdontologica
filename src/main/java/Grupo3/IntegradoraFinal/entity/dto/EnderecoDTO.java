package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.EnderecoEntity;

public class EnderecoDTO {

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        this.rua = enderecoEntity.getRua();
        this.numero = enderecoEntity.getNumero();
        this.bairro = enderecoEntity.getBairro();
        this.cidade = enderecoEntity.getCidade();
        this.estado = enderecoEntity.getEstado();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
