package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
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

    public UsuarioDTO create(CriarUsuarioDTO criarUsuarioDTO) {
        return new UsuarioDTO(usuarioRepository.saveAndFlush(new UsuarioEntity(criarUsuarioDTO)));
    }

    @Override
    public UsuarioDTO getById(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    @Override
    public List<UsuarioDTO> getByAll() {
        List<UsuarioDTO> usuarioList = new ArrayList<>();
        for (UsuarioEntity usuario : usuarioRepository.findAll()) {
            usuarioList.add(new UsuarioDTO(usuario));
        }
        return usuarioList;
    }

    @Override
    public String delete(Long id) {
        usuarioRepository.delete(new UsuarioEntity(id));
        return "O usuario " + id + " foi deletado com sucesso!";
    }

    public UsuarioDTO update(Long id, CriarUsuarioDTO criarUsuarioDTO) {
        UsuarioEntity usuario = new UsuarioEntity(criarUsuarioDTO);
        usuario.setIdUsuario(id);
        return new UsuarioDTO(usuarioRepository.saveAndFlush(usuario));
    }
}
