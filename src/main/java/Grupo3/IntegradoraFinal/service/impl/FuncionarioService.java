package Grupo3.IntegradoraFinal.service.impl;


import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarFuncionarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.repository.IFuncionarioRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService implements IService<FuncionarioDTO> {
    @Autowired
    IFuncionarioRepository funcionarioRepository;
   @Autowired
    UsuarioService usuarioService;

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


    public FuncionarioDTO create (CriarFuncionarioDTO criarFuncionarioDTO) {
        UsuarioDTO usuarioDTO = usuarioService.create(new CriarUsuarioDTO(criarFuncionarioDTO));
        return mapperEntityToDTO(funcionarioRepository.saveAndFlush(new FuncionarioEntity(criarFuncionarioDTO, usuarioDTO.getId())));
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
