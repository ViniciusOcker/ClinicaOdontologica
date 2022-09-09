package Grupo3.IntegradoraFinal.entity.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CriarPacienteDTO {

    private String nome;
    private String sobrenome;
    private CriarEnderecoDTO endereco;
    private String rg;
    private String nomeDeUsuario;
    private String senha;

    public CriarPacienteDTO(String nome, String sobrenome, CriarEnderecoDTO endereco, String rg, String nomeDeUsuario, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
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

    public CriarEnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(CriarEnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
