package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarEnderecoDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.EnderecoDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.DentistaErrorDTO;
import Grupo3.IntegradoraFinal.entity.dto.error.EnderecoErrorDTO;
import Grupo3.IntegradoraFinal.exception.BadRequestException;
import Grupo3.IntegradoraFinal.exception.ResourceNotFoundException;
import Grupo3.IntegradoraFinal.repository.IEnderecoRepository;
import Grupo3.IntegradoraFinal.validation.EnderecoValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService  {
    @Autowired
    IEnderecoRepository enderecoRepository;

    @Autowired
    EnderecoValidation validation;

    public EnderecoDTO create(CriarEnderecoDTO criarEnderecoDTO) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoErrorDTO error = validation.validation(criarEnderecoDTO);
        if(error.getBairro() == null && error.getCidade() == null && error.getComplemento() == null && error.getEstado() == null && error.getNumero() == null && error.getPontoDeReferencia() == null && error.getRua() == null){
            return new EnderecoDTO(enderecoRepository.saveAndFlush(new EnderecoEntity(criarEnderecoDTO)));
        }
        else{
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }

    public EnderecoDTO getById(Long id) throws BadRequestException {
        return new EnderecoDTO(enderecoRepository.findById(id).orElseThrow(()->{return new BadRequestException("Não foi possivel localizar o id " + id + " de endereço!");}));
    }

    public List<EnderecoDTO> getByAll() throws ResourceNotFoundException {
        List<EnderecoDTO> enderecoList = new ArrayList<>();
        for (EnderecoEntity endereco : enderecoRepository.findAll()) {
            enderecoList.add(new EnderecoDTO(endereco));
        }
        if(enderecoList.isEmpty()){
            throw new ResourceNotFoundException("Lista de endereços está vazio");
        }
        return enderecoList;
    }

    public String delete(Long id) throws ResourceNotFoundException {
        try{
            enderecoRepository.deleteById(id);
        } catch(Exception e){
            throw new ResourceNotFoundException("Não foi possivel deletar o id " + id + " de endereço");
        }
        return id.toString();
    }

    public EnderecoDTO update(Long id, CriarEnderecoDTO criarEnderecoDTO) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoErrorDTO error = validation.validation(criarEnderecoDTO);
        if(error.getBairro() == null && error.getCidade() == null && error.getComplemento() == null && error.getEstado() == null && error.getNumero() == null && error.getPontoDeReferencia() == null && error.getRua() == null){
            EnderecoEntity enderecoEntity = new EnderecoEntity(criarEnderecoDTO);
            enderecoEntity.setIdEndereco(id);
            try{
                return new EnderecoDTO(enderecoRepository.saveAndFlush(enderecoEntity));
            }
            catch (Exception e){
                error.setRua("Este endereço não existe!");
                throw new BadRequestException(objectMapper.writeValueAsString(error));
            }
        } else {
            throw new BadRequestException(objectMapper.writeValueAsString(error));
        }
    }
}
