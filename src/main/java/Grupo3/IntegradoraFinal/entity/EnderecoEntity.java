package Grupo3.IntegradoraFinal.entity;

import Grupo3.IntegradoraFinal.entity.dto.CriarEnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "Endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Long id;
    private String complemento;
    @Column(nullable = false)
    private String rua;
    private String numero;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    private String pontoDeReferencia;

    public EnderecoEntity(Long id, String complemento, String rua, String numero, String bairro, String cidade, String estado, String pontoDeReferencia) {
        this.id = id;
        this.complemento = complemento;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pontoDeReferencia = pontoDeReferencia;
    }

    public EnderecoEntity() {
    }

    public EnderecoEntity(Long id) {
        this.id = id;
    }

    public EnderecoEntity(CriarEnderecoDTO criarEnderecoDTO) {
        this.complemento = criarEnderecoDTO.getComplemento();
        this.rua = criarEnderecoDTO.getRua();
        this.numero = criarEnderecoDTO.getNumero();
        this.bairro = criarEnderecoDTO.getBairro();
        this.cidade = criarEnderecoDTO.getCidade();
        this.estado = criarEnderecoDTO.getEstado();
        this.pontoDeReferencia = criarEnderecoDTO.getPontoDeReferencia();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPontoDeReferencia() {
        return pontoDeReferencia;
    }

    public void setPontoDeReferencia(String pontoDeReferencia) {
        this.pontoDeReferencia = pontoDeReferencia;
    }

    @Override
    public String toString() {
        return "EnderecoEntity{" +
                "id=" + id +
                ", complemento='" + complemento + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", pontoDeReferencia='" + pontoDeReferencia + '\'' +
                '}';
    }
}
