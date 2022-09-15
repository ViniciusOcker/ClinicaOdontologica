package Grupo3.IntegradoraFinal.service.impl;

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
        PacienteDTO pacienteDTO = mapperEntityToDTO(pacienteRepository.saveAndFlush(new PacienteEntity(criarPacienteDTO, enderecoDTO.getIdEndereco())));
        pacienteDTO.setEndereco(enderecoDTO);
        return pacienteDTO;
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
        pacienteRepository.deleteById(id);
        enderecoService.delete(idEndereco);
        return "O paciente " + id + " foi deletado com sucesso!";
    }

    public PacienteDTO update(Long id, CriarPacienteDTO criarPacienteDTO) {
        PacienteEntity pacienteEntity = pacienteRepository.findById(id).get();
        EnderecoDTO enderecoDTO = enderecoService.update(pacienteEntity.getEndereco().getIdEndereco(),criarPacienteDTO.getEndereco());
        PacienteEntity pacienteEntity2 = new PacienteEntity(criarPacienteDTO, enderecoDTO.getIdEndereco());
        pacienteEntity2.setIdPaciente(id);
        return mapperEntityToDTO(pacienteRepository.saveAndFlush(pacienteEntity2));
    }

    public List<PacienteDTO> findPaciente(String nome, String sobrenome){
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();
        for (PacienteEntity pacienteEntity:pacienteRepository.findNameFull("%"+nome+"%", "%"+sobrenome+"%")) {
            pacienteDTOList.add(mapperEntityToDTO(pacienteEntity));
        }
        return pacienteDTOList;
    }
}
