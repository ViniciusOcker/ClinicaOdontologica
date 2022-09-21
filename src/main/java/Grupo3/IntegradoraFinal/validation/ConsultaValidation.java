package Grupo3.IntegradoraFinal.validation;

import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.ConsultaErrorDTO;
import Grupo3.IntegradoraFinal.repository.IConsultaRepository;
import Grupo3.IntegradoraFinal.repository.IDentistaRepository;
import Grupo3.IntegradoraFinal.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ConsultaValidation {

    private static final int minimoMinutoConsulta = 15;
    private static final int maximoMinutoConsulta = 60;
    private static final String dataRegexp = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4} [0-9]{2}:[0-9]{2}:[0-9]{2}$";

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

    public String validationData (Long id, String inicio, String fim){

        if(!(Evalido(inicio, dataRegexp) && Evalido(fim, dataRegexp))
        ) {
            return "A Data de início ou de fim  está no formato incorreto [Formato correto: dd/MM/yyyy HH:mm:ss]";
        }
        LocalDateTime inicioTime = LocalDateTime.parse(inicio, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        LocalDateTime fimTime = LocalDateTime.parse(fim, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        if(fimTime.isAfter(inicioTime)){
            return "A data de fim não pode ser inferior a de início";
        } else if (fimTime.until(inicioTime, ChronoUnit.MINUTES) < minimoMinutoConsulta) {
            return "A duração da consulta é inferior ao tempo permitido";
        } else if (fimTime.until(inicioTime, ChronoUnit.MINUTES) > maximoMinutoConsulta) {
            return "A duração da consulta é superior ao tempo permitido";
        } else if (!consultaRepository.getByConsultaData(id,inicioTime,fimTime).isEmpty()) {
            return "Este período de tempo está ocupado";
        }
        return null;
    }

    public boolean Evalido(String texto, String regexp){
        Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }

}
