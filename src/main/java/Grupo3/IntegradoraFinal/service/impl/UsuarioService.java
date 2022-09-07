package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.repository.IUsuarioRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IService<UsuarioDTO> {
    @Autowired
    IUsuarioRepository usuarioRepository;

    private UsuarioEntity mapperDTOToEntity(UsuarioDTO usuarioDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioEntity usuario = objectMapper.convertValue(usuarioDTO, UsuarioEntity.class);
        return usuario;
    }

    private UsuarioDTO mapperEntityToDTO(UsuarioEntity usuarioEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioDTO usuario = objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
        return usuario;
    }

    @Override
    public UsuarioDTO create(UsuarioDTO usuarioDTO) {
        return null;
    }

    @Override
    public UsuarioDTO getById(int id) {
        return null;
    }

    @Override
    public List<UsuarioDTO> getByAll() {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public UsuarioDTO update(int id, UsuarioDTO usuarioDTO) {
        return null;
    }
}
