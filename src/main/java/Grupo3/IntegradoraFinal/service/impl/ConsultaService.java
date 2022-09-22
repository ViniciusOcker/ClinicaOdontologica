package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.ConsultaErrorDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.DentistaErrorDTO;
import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.repository.IConsultaRepository;
import Grupo3.IntegradoraFinal.service.IService;
import Grupo3.IntegradoraFinal.validation.ConsultaValidation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService implements IService<ConsultaDTO> {
    @Autowired
    IConsultaRepository consultaRepository;

    @Autowired
    ConsultaValidation validation;

    public ConsultaDTO create(CriarConsultaDTO criarConsultaDTO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaErrorDTO error = validation.validation(criarConsultaDTO);
        if (error.getIdDentista() == null && error.getIdPaciente() == null && error.getTempoConsulta() == null){
            try{
                return new ConsultaDTO(consultaRepository.saveAndFlush(new ConsultaEntity(criarConsultaDTO)));
            }
            catch (Exception e){
                error.setTempoConsulta("Não foi possivel registrar!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    @Override
    public ConsultaDTO getById(Long id) throws ResourceNotFoundException {
        return new ConsultaDTO(consultaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não foi possivel localizar o id " + id + " de consulta!")));
    }

    @Override
    public List<ConsultaDTO> getByAll() throws ResourceNotFoundException {
        List<ConsultaDTO> consultaList = new ArrayList<>();
        for (ConsultaEntity consulta : consultaRepository.findAll()) {
            consultaList.add(new ConsultaDTO(consulta));
        }
        if(consultaList.isEmpty()){
            throw new ResourceNotFoundException("A lista de consulta está vazia");
        }
        return consultaList;
    }

    @Override
    public String delete(Long id) throws ResourceNotFoundException {
        try{
            consultaRepository.deleteById(id);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel deletar a consulta com o id " + id);
        }
        return "A consulta " + id + " foi deletado com sucesso!";
    }

    public ConsultaDTO update(Long id, CriarConsultaDTO criarConsultaDTO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaErrorDTO error = validation.validation(criarConsultaDTO);
        if (error.getIdDentista() == null && error.getIdPaciente() == null && error.getTempoConsulta() == null){
            try{
                ConsultaEntity consulta = new ConsultaEntity(criarConsultaDTO);
                consulta.setIdConsulta(id);
                return new ConsultaDTO(consultaRepository.saveAndFlush(consulta));
            }
            catch (Exception e){
                error.setTempoConsulta("Não foi atualizar a consulta de id " + id);
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    public List<ConsultaDTO> getByIdDentista(Long id) throws ResourceNotFoundException {
        List<ConsultaDTO> consultaList = new ArrayList<>();
        for (ConsultaEntity consulta : consultaRepository.getByIdDentista(id).get()) {
            consultaList.add(new ConsultaDTO(consulta));
        }
        if(consultaList.isEmpty()){
            throw new ResourceNotFoundException("Não existe consultas com o dentista de id " + id);
        }
        return consultaList;
    }

    public List<ConsultaDTO> getByIdPaciente(Long id) throws ResourceNotFoundException {
        List<ConsultaDTO> consultaList = new ArrayList<>();
        for (ConsultaEntity consulta : consultaRepository.getByIdPaciente(id).get()) {
            consultaList.add(new ConsultaDTO(consulta));
        }
        if(consultaList.isEmpty()){
            throw new ResourceNotFoundException("Não existe consultas com o paciente de id " + id);
        }
        return consultaList;
    }
}
