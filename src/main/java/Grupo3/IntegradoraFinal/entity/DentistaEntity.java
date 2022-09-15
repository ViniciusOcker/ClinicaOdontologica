package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Dentista")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DentistaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario")
    private Long idDentista;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(unique = true, nullable = false)
    private String cro;

    public DentistaEntity(Long idDentista, String nome, String sobrenome, String cro, boolean admin, UsuarioEntity usuario, Set<ConsultaEntity> consultas) {
        this.idDentista = idDentista;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
    }

    public DentistaEntity() {
    }

    public DentistaEntity(CriarDentistaDTO criarDentistaDTO) {
        this.nome = criarDentistaDTO.getNome();
        this.sobrenome = criarDentistaDTO.getSobrenome();
        this.cro = criarDentistaDTO.getCro();
    }

    public DentistaEntity(Long idDentista) {
        this.idDentista = idDentista;
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
