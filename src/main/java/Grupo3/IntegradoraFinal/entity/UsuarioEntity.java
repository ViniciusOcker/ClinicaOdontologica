package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name ="Usuario")
public class UsuarioEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(unique = true, nullable = false)
    private String nomeDeUsuario;
    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private UsuarioRoles roles;

    public UsuarioEntity(Long idUsuario, String nomeDeUsuario, String senha, UsuarioRoles roles) {
        this.idUsuario = idUsuario;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.roles = roles;
    }

    public UsuarioEntity() {
    }

    public UsuarioEntity(CriarUsuarioDTO criarUsuarioDTO) {
        this.nomeDeUsuario = criarUsuarioDTO.getNomeDeUsuario();
        this.senha = criarUsuarioDTO.getSenha();
        if(criarUsuarioDTO.isAdmin()) {
            this.roles = UsuarioRoles.ROLE_ADMIN;
        }
        else{
            this.roles = UsuarioRoles.ROLE_USER;
        }
        this.idUsuario = null;
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

    public UsuarioRoles getRoles() {
        return roles;
    }

    public void setRoles(UsuarioRoles roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles.name());
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nomeDeUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
