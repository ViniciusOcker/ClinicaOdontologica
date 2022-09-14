package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarUsuarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.repository.IUsuarioRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public UsuarioDTO create(CriarUsuarioDTO criarUsuarioDTO) {
        return mapperEntityToDTO(usuarioRepository.saveAndFlush(new UsuarioEntity(criarUsuarioDTO)));
    }

    @Override
    public UsuarioDTO getById(Long id) {
        return mapperEntityToDTO(usuarioRepository.findById(id).get());
    }

    @Override
    public List<UsuarioDTO> getByAll() {
        List<UsuarioDTO> usuarioList = new ArrayList<>();
        for (UsuarioEntity usuario : usuarioRepository.findAll()) {
            usuarioList.add(mapperEntityToDTO(usuario));
        }
        return usuarioList;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO) {
        return null;
    }
}
