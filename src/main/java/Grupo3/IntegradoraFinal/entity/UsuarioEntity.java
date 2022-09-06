package Grupo3.IntegradoraFinal.entity;

import javax.persistence.*;

@Entity
@Table(name ="Usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nomeDeUsuario;
    @Column(nullable = false)
    private String senha;

    public UsuarioEntity(Long id, String nomeDeUsuario, String senha) {
        this.id = id;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
    }

    public UsuarioEntity() {
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

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", nomeDeUsuario='" + nomeDeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
