package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarEnderecoDTO;
import Grupo3.IntegradoraFinal.entity.dto.EnderecoDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.repository.IEnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService  {
    @Autowired
    IEnderecoRepository enderecoRepository;

    public EnderecoDTO create(CriarEnderecoDTO criarEnderecoDTO) {
        return new EnderecoDTO(enderecoRepository.saveAndFlush(new EnderecoEntity(criarEnderecoDTO)));
    }

    public EnderecoDTO getById(Long id) {
        return new EnderecoDTO(enderecoRepository.findById(id).get());
    }

    public List<EnderecoDTO> getByAll() {
        List<EnderecoDTO> enderecoList = new ArrayList<>();
        for (EnderecoEntity endereco : enderecoRepository.findAll()) {
            enderecoList.add(new EnderecoDTO(endereco));
        }
        return enderecoList;
    }

    public String delete(Long id) {
        enderecoRepository.deleteById(id);
        return id.toString();
    }

    public EnderecoDTO update(Long id, CriarEnderecoDTO criarEnderecoDTO) {
        EnderecoEntity enderecoEntity = new EnderecoEntity(criarEnderecoDTO);
        enderecoEntity.setIdEndereco(id);
        return new EnderecoDTO(enderecoRepository.saveAndFlush(enderecoEntity));
    }
}
