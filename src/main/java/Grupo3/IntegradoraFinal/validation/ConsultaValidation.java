package Grupo3.IntegradoraFinal.validation;

import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.ConsultaErrorDTO;
import Grupo3.IntegradoraFinal.repository.IConsultaRepository;
import Grupo3.IntegradoraFinal.repository.IDentistaRepository;
import Grupo3.IntegradoraFinal.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaValidation {

    private static final int minimoMinutoConsulta = 15;
    private static final int maximoMinutoConsulta = 60;

    @Autowired
    IConsultaRepository consultaRepository;

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IDentistaRepository dentistaRepository;

    public ConsultaValidation() {
    }

    public ConsultaErrorDTO validation(CriarConsultaDTO criarConsultaDTO){
        return new ConsultaErrorDTO(validationPaciente(criarConsultaDTO.getIdPaciente()),validationDentista(criarConsultaDTO.getIdDentista()),null);
    }

    public String validationPaciente(Long id) {
        if (!pacienteRepository.existsById(id)) {
            return "Este Paciente não existe";
        }
        return null;
    }

    public String validationDentista(Long id) {
        if (!dentistaRepository.existsById(id)) {
            return "Este Dentista não existe";
        }
        return null;
    }

}
