package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="Usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long id;
    @Column(unique = true, nullable = false)
    private String nomeDeUsuario;
    @Column(nullable = false)
    private String senha;
    private boolean admin;

    public UsuarioEntity(Long id, String nomeDeUsuario, String senha, boolean admin) {
        this.id = id;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.admin = admin;
    }

    public UsuarioEntity() {
    }

    public UsuarioEntity(CriarUsuarioDTO criarUsuarioDTO) {
        this.nomeDeUsuario = criarUsuarioDTO.getNomeDeUsuario();
        this.senha = criarUsuarioDTO.getSenha();
        this.admin = criarUsuarioDTO.isAdmin();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
