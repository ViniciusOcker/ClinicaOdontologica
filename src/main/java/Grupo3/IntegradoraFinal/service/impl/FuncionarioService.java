package Grupo3.IntegradoraFinal.service.impl;


import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.EnderecoDTO;
import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import Grupo3.IntegradoraFinal.repository.IFuncionarioRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService implements IService<FuncionarioDTO> {
    @Autowired
    IFuncionarioRepository funcionarioRepository;

    private FuncionarioEntity mapperDTOToEntity(FuncionarioDTO funcionarioDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        FuncionarioEntity funcionario = objectMapper.convertValue(funcionarioDTO, FuncionarioEntity.class);
        return funcionario;
    }

    private FuncionarioDTO mapperEntityToDTO(FuncionarioEntity funcionarioEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        FuncionarioDTO funcionario = objectMapper.convertValue(funcionarioEntity, FuncionarioDTO.class);
        return funcionario;
    }

    @Override
    public FuncionarioDTO create(FuncionarioDTO funcionarioDTO) {
        return null;
    }

    @Override
    public FuncionarioDTO getById(int id) {
        return null;
    }

    @Override
    public List<FuncionarioDTO> getByAll() {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public FuncionarioDTO update(int id, FuncionarioDTO funcionarioDTO) {
        return null;
    }
}
