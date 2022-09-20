package Grupo3.IntegradoraFinal.entity.dto.error;

public class ConsultaErrorDTO {
    private String idPaciente;
    private String idDentista;
    private String tempoConsulta;

    public ConsultaErrorDTO() {
    }

    public ConsultaErrorDTO(String idPaciente, String idDentista, String tempoConsulta) {
        this.idPaciente = idPaciente;
        this.idDentista = idDentista;
        this.tempoConsulta = tempoConsulta;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(String idDentista) {
        this.idDentista = idDentista;
    }

    public String getTempoConsulta() {
        return tempoConsulta;
    }

    public void setTempoConsulta(String tempoConsulta) {
        this.tempoConsulta = tempoConsulta;
    }
}
