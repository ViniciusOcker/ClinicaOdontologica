package Grupo3.IntegradoraFinal.entity.dto;

public class CriarUsuarioDTO {
    private String nomeDeUsuario;
    private String senha;

    public CriarUsuarioDTO(String nomeDeUsuario, String senha) {
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
    }

    public CriarUsuarioDTO() {
    }

    public CriarUsuarioDTO(CriarPacienteDTO criarPacienteDTO) {
        this.nomeDeUsuario = criarPacienteDTO.getNomeDeUsuario();
        this.senha = criarPacienteDTO.getSenha();
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
