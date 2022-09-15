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

    private EnderecoEntity mapperDTOToEntity(EnderecoDTO enderecoDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoEntity endereco = objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);
        return endereco;
    }

    private EnderecoDTO mapperEntityToDTO(EnderecoEntity enderecoEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoDTO endereco = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        return endereco;
    }

    public EnderecoDTO create(CriarEnderecoDTO criarEnderecoDTO) {
        return mapperEntityToDTO(enderecoRepository.saveAndFlush(new EnderecoEntity(criarEnderecoDTO)));
    }

    public EnderecoDTO getById(Long id) {
        return mapperEntityToDTO(enderecoRepository.findById(id).get());
    }

    public List<EnderecoDTO> getByAll() {
        List<EnderecoDTO> enderecoList = new ArrayList<>();
        for (EnderecoEntity endereco : enderecoRepository.findAll()) {
            enderecoList.add(mapperEntityToDTO(endereco));
        }
        return enderecoList;
    }

    public String delete(Long id) {
        enderecoRepository.delete(new EnderecoEntity(id));
        return id.toString();
    }

    public EnderecoDTO update(Long id, CriarEnderecoDTO criarEnderecoDTO) {
        EnderecoEntity enderecoEntity = new EnderecoEntity(criarEnderecoDTO);
        enderecoEntity.setIdEndereco(id);
        return mapperEntityToDTO(enderecoRepository.saveAndFlush(enderecoEntity));
    }
}
