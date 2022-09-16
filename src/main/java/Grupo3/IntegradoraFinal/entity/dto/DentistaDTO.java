package Grupo3.IntegradoraFinal.entity.dto;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import java.io.Serializable;

public class DentistaDTO implements Serializable {
    private Long idDentista;
    private String nome;
    private String sobrenome;
    private String cro;

    public DentistaDTO(Long idDentista, String nome, String sobrenome, String cro, boolean admin) {
        this.idDentista = idDentista;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
    }

    public DentistaDTO() {
    }

    public DentistaDTO(DentistaEntity dentistaEntity) {
        this.idDentista = dentistaEntity.getIdDentista();
        this.nome = dentistaEntity.getNome();
        this.sobrenome = dentistaEntity.getSobrenome();
        this.cro = dentistaEntity.getCro();
    }

    public Long getIdDentista() {
        return idDentista;
    }
    public void setIdDentista(Long idDentista) {
        this.idDentista = idDentista;
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }
}
