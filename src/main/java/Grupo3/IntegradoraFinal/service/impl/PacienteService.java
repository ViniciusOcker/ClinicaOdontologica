package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.*;
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

    @Autowired
    private EnderecoService enderecoService;

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
        EnderecoDTO enderecoDTO = enderecoService.create(criarPacienteDTO.getEndereco());
        return mapperEntityToDTO(pacienteRepository.saveAndFlush(new PacienteEntity(criarPacienteDTO, enderecoDTO.getId())));
    }

    @Override
    public PacienteDTO getById(Long id) {
        return mapperEntityToDTO(pacienteRepository.findById(id).get());
    }

    @Override
    public List<PacienteDTO> getByAll() {
        List<PacienteDTO> pacienteList = new ArrayList<>();
        for (PacienteEntity paciente: pacienteRepository.findAll()) {
            pacienteList.add(mapperEntityToDTO(paciente));
        }
        return pacienteList;
    }

    @Override
    public String delete(Long id) {
        PacienteEntity paciente = pacienteRepository.findById(id).get();
        Long idEndereco = paciente.getEndereco().getIdEndereco();
        if(enderecoService.delete(idEndereco).equals(idEndereco.toString())){
            pacienteRepository.delete(new PacienteEntity(id));
            return "O paciente " + id + " foi deletado com sucesso!";
        }
        else{
            return "Erro ao deletar!";
        }
    }

    @Override
    public PacienteDTO update(Long id, PacienteDTO pacienteDTO) {
        return null;
    }
}
