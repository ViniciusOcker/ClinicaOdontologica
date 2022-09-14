package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name ="Usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(unique = true, nullable = false)
    private String nomeDeUsuario;
    @Column(nullable = false)
    private String senha;
    private boolean admin;

    public UsuarioEntity(Long idUsuario, String nomeDeUsuario, String senha, boolean admin) {
        this.idUsuario = idUsuario;
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

    public UsuarioEntity(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
