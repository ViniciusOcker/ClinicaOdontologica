package Grupo3.IntegradoraFinal.service.impl;


import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.dto.*;
import Grupo3.IntegradoraFinal.repository.IPacienteRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioService usuarioService;

    private PacienteEntity mapperDTOToEntity(PacienteDTO pacienteDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteEntity paciente = objectMapper.convertValue(pacienteDTO, PacienteEntity.class);
        return paciente;
    }

    private PacienteDTO mapperEntityToDTO(PacienteEntity pacienteEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteDTO paciente = objectMapper.convertValue(pacienteEntity, PacienteDTO.class);
        return paciente;
    }


    public PacienteDTO create(CriarPacienteDTO criarPacienteDTO) {
        UsuarioDTO usuarioDTO = usuarioService.create(new CriarUsuarioDTO(criarPacienteDTO));
        EnderecoDTO enderecoDTO = enderecoService.create(criarPacienteDTO.getEndereco());
        return mapperEntityToDTO(pacienteRepository.saveAndFlush(new PacienteEntity(criarPacienteDTO, usuarioDTO.getId(), enderecoDTO.getId())));
    }


    public PacienteDTO getById(int id) {
        return null;
    }


    public List<PacienteDTO> getByAll() {
        return null;
    }


    public String delete(int id) {
        return null;
    }


    public PacienteDTO update(int id, PacienteDTO pacienteDTO) {
        return null;
    }
}
