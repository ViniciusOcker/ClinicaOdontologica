package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PacienteDTO implements Serializable {
    private Long id;
    private String nome;
    private String sobrenome;
    private EnderecoDTO endereco;
    private String rg;
    private LocalDate dataDeAlta;
    private UsuarioDTO usuario;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PacienteDTO(Long id, String nome, String sobrenome, EnderecoDTO endereco, String rg, LocalDate dataDeAlta, Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO usuario) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
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

    public Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO usuario) {
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