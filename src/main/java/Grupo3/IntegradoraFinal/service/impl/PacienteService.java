package Grupo3.IntegradoraFinal.service.impl;


import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.repository.IPacienteRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IService<PacienteDTO> {
    @Autowired
    private IPacienteRepository pacienteRepository;

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

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        return null;
    }

    @Override
    public PacienteDTO getById(int id) {
        return null;
    }

    @Override
    public List<PacienteDTO> getByAll() {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public PacienteDTO update(int id, PacienteDTO pacienteDTO) {
        return null;
    }
}
