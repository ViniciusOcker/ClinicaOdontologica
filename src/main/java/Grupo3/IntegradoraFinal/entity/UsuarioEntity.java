package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name ="Usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(unique = true, nullable = false)
    private String nomeDeUsuario;
    @Column(nullable = false)
    private String senha;
    private Boolean admin;

    public UsuarioEntity(Long idUsuario, String nomeDeUsuario, String senha, Boolean admin) {
        this.idUsuario = idUsuario;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.admin = admin;
    }

    public UsuarioEntity() {
    }

    public UsuarioEntity(CriarUsuarioDTO criarUsuarioDTO) {
        PasswordEncoder passwordHash = new BCryptPasswordEncoder();
        this.nomeDeUsuario = criarUsuarioDTO.getNomeDeUsuario();
        this.senha = passwordHash.encode(criarUsuarioDTO.getSenha());
        this.admin = criarUsuarioDTO.isAdmin();
        this.idUsuario = null;
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

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
