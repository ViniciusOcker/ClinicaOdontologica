package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import java.io.Serializable;

public class EnderecoDTO implements Serializable {
    private Long idEndereco;
    private String complemento;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pontoDeReferencia;

    public EnderecoDTO(Long idEndereco, String complemento, String rua, String numero, String bairro, String cidade, String estado, String pontoDeReferencia) {
        this.idEndereco = idEndereco;
        this.complemento = complemento;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pontoDeReferencia = pontoDeReferencia;
    }

    public EnderecoDTO() {
    }

    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        this.idEndereco = enderecoEntity.getIdEndereco();
        this.complemento = enderecoEntity.getComplemento();
        this.rua = enderecoEntity.getRua();
        this.numero = enderecoEntity.getNumero();
        this.bairro = enderecoEntity.getBairro();
        this.cidade = enderecoEntity.getCidade();
        this.estado = enderecoEntity.getEstado();
        this.pontoDeReferencia = enderecoEntity.getPontoDeReferencia();
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }
}
