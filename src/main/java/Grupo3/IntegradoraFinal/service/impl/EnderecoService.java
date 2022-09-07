package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;
import Grupo3.IntegradoraFinal.entity.dto.EnderecoDTO;
import Grupo3.IntegradoraFinal.repository.IEnderecoRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService implements IService<EnderecoDTO> {
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

    @Override
    public EnderecoDTO create(EnderecoDTO enderecoDTO) {
        return null;
    }

    @Override
    public EnderecoDTO getById(int id) {
        return null;
    }

    @Override
    public List<EnderecoDTO> getByAll() {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public EnderecoDTO update(int id, EnderecoDTO enderecoDTO) {
        return null;
    }
}
