package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.DentistaErrorDTO;
import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.repository.IDentistaRepository;
import Grupo3.IntegradoraFinal.service.IService;
import Grupo3.IntegradoraFinal.validation.DentistaValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistaService implements IService<DentistaDTO> {
    @Autowired
    IDentistaRepository dentistaRepository;

    @Autowired
    DentistaValidation validation;

    public DentistaDTO create (CriarDentistaDTO criarDentistaDTO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaErrorDTO error = validation.validation(criarDentistaDTO);
        if (error.getNome() == null && error.getSobrenome() == null && error.getCro() == null){
            try{
                return new DentistaDTO(dentistaRepository.saveAndFlush(new DentistaEntity(criarDentistaDTO)));
            }
            catch (Exception e){
                error.setCro("Este CRO já está registrado!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    @Override
    public DentistaDTO getById(Long id) throws ResourceNotFoundException {
        return new DentistaDTO(dentistaRepository.findById(id).orElseThrow(()->{return new ResourceNotFoundException("Não foi possivel localizar o id " + id + " de dentista!");}));
    }

    @Override
    public List<DentistaDTO> getByAll() throws ResourceNotFoundException {
        List<DentistaDTO> dentistaList = new ArrayList<>();
        for (DentistaEntity dentista:dentistaRepository.findAll()) {
            dentistaList.add(new DentistaDTO(dentista));
        }
        if(dentistaList.isEmpty()){
            throw new ResourceNotFoundException("Lista de dentistas está vazio");
        }
        return dentistaList;
    }

    @Override
    public String delete(Long id) throws ResourceNotFoundException {
        try{
            dentistaRepository.deleteById(id);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel deletar o id " + id + " de dentista");
        }
        return "Dentista " + id + " foi deletado com sucesso!";
    }

    public DentistaDTO update(Long id, CriarDentistaDTO criarDentistaDTO) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaErrorDTO error = validation.validation(criarDentistaDTO);
        if (error.getNome() == null && error.getSobrenome() == null && error.getCro() == null){
            DentistaEntity dentista = new DentistaEntity(criarDentistaDTO);
            dentista.setIdDentista(id);
            try{
                return new DentistaDTO(dentistaRepository.saveAndFlush(dentista));
            }
            catch (Exception e){
                error.setNome("Este dentista não existe!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    public List<DentistaDTO> findDentista(String nome, String sobrenome) throws BadRequestException {
        if(validation.Evalido(nome, validation.getRegexpText()) && validation.Evalido(sobrenome, validation.getRegexpText())){
            List<DentistaDTO> dentistaDTOList = new ArrayList<>();
            for (DentistaEntity dentista:dentistaRepository.findNameFull("%"+nome+"%", "%"+sobrenome+"%").get()) {
                dentistaDTOList.add(new DentistaDTO(dentista));
            }
            return dentistaDTOList;
        }
        else {
            throw new BadRequestException("O nome ou sobrenome contém caracteres invalidos!");
        }
    }
}
