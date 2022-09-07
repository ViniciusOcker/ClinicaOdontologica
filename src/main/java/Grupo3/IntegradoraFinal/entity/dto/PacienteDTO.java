package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacienteDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private EnderecoDTO endereco;
    private String rg;
    private LocalDate dataDeAlta;
    private UsuarioDTO usuario;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PacienteDTO(Integer id, String nome, String sobrenome, EnderecoEntity endereco, String rg, LocalDate dataDeAlta, UsuarioDTO usuario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataDeAlta = dataDeAlta;
        this.usuario = usuario;
    }

    public PacienteDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }
    @Override
    public String toString() {
        return "PacienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco=" + endereco +
                ", rg='" + rg + '\'' +
                ", dataDeAlta=" + dataDeAlta +
                ", usuario=" + usuario +
                ", formatter=" + formatter +
                '}';
    }
}