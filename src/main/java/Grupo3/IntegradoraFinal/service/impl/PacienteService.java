package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.dto.*;
import Grupo3.IntegradoraFinal.entity.dto.error.DentistaErrorDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.EnderecoErrorDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.PacienteErrorDTO;
import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.repository.IPacienteRepository;
import Grupo3.IntegradoraFinal.service.IService;
import Grupo3.IntegradoraFinal.validation.PacienteValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IService<PacienteDTO> {
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PacienteValidation validation;

    public PacienteDTO create(CriarPacienteDTO criarPacienteDTO) throws Exception {
        EnderecoDTO enderecoDTO = null;
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteErrorDTO error = validation.validation(criarPacienteDTO);
        try {
            enderecoDTO = enderecoService.create(criarPacienteDTO.getEndereco());
        }
        catch (BadRequestException e){
            error.setEndereco(e.getMessage());
        }
        if (error.getNome() == null && error.getSobrenome() == null && error.getEndereco() == null && error.getDataDeAlta() == null && error.getRg() == null){
            try{
                PacienteDTO pacienteDTO = new PacienteDTO(pacienteRepository.saveAndFlush(new PacienteEntity(criarPacienteDTO, enderecoDTO.getIdEndereco())));
                pacienteDTO.setEndereco(enderecoDTO);
                return pacienteDTO;
            }
            catch (Exception e){
                error.setRg("Este RG já está registrado!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    @Override
    public PacienteDTO getById(Long id) throws ResourceNotFoundException {
        return new PacienteDTO(pacienteRepository.findById(id).orElseThrow(() -> { return new ResourceNotFoundException("Não foi possivel localizar o id " + id + " de paciente!");}));
    }

    @Override
    public List<PacienteDTO> getByAll() throws ResourceNotFoundException {
        List<PacienteDTO> pacienteList = new ArrayList<>();
        for (PacienteEntity paciente: pacienteRepository.findAll()) {
            pacienteList.add(new PacienteDTO(paciente));
        }
        if(pacienteList.isEmpty()){
            throw new ResourceNotFoundException("Lista de pacientes está vazio");
        }
        return pacienteList;
    }

    @Override
    public String delete(Long id) throws ResourceNotFoundException {
        try{
            PacienteEntity paciente = pacienteRepository.findById(id).get();
            Long idEndereco = paciente.getEndereco().getIdEndereco();
            pacienteRepository.deleteById(id);
            enderecoService.delete(idEndereco);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel deletar o id " + id + " de paciente");
        }
        return "O paciente " + id + " foi deletado com sucesso!";
    }

    public PacienteDTO update(Long id, CriarPacienteDTO criarPacienteDTO) throws Exception {
        PacienteEntity pacienteEntity = pacienteRepository.findById(id).orElseThrow(() ->{return new BadRequestException("Este paciente não existe");});
        EnderecoDTO enderecoDTO = null;
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteErrorDTO error = validation.validation(criarPacienteDTO);
        try{
            enderecoDTO = enderecoService.update(pacienteEntity.getEndereco().getIdEndereco(),criarPacienteDTO.getEndereco());
        }
        catch (Exception e){
            error.setEndereco(e.getMessage());
        }
        if (error.getNome() == null && error.getSobrenome() == null && error.getEndereco() == null && error.getDataDeAlta() == null && error.getRg() == null){
            try{
                PacienteEntity pacienteEntity2 = new PacienteEntity(criarPacienteDTO, enderecoDTO.getIdEndereco());
                pacienteEntity2.setIdPaciente(id);
                return new PacienteDTO(pacienteRepository.saveAndFlush(pacienteEntity2));
            }
            catch (Exception e){
                error.setRg("Este RG já está registrado!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    public List<PacienteDTO> findPaciente(String nome, String sobrenome) throws BadRequestException {

        if(validation.Evalido(nome, validation.getRegexpText()) && validation.Evalido(sobrenome, validation.getRegexpText())){
            List<PacienteDTO> pacienteDTOList = new ArrayList<>();
            for (PacienteEntity pacienteEntity:pacienteRepository.findNameFull("%"+nome+"%", "%"+sobrenome+"%").get()) {
                pacienteDTOList.add(new PacienteDTO(pacienteEntity));
            }
            return pacienteDTOList;
        }
        else {
            throw new BadRequestException("O nome ou sobrenome contém caracteres invalidos!");
        }
    }
}
