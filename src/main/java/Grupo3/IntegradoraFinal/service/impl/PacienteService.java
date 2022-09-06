package Grupo3.IntegradoraFinal.service.impl;


import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.repository.IPacienteRepository;
import Grupo3.IntegradoraFinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IService<PacienteDTO> {
    @Autowired
    private IPacienteRepository pacienteRepository;

    public PacienteDTO create(PacienteDTO pacienteDTO){
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        pacienteEntity = pacienteRepository.save(pacienteEntity);
        pacienteDTO = new PacienteDTO(pacienteEntity);

        return pacienteDTO;
    }

    public PacienteDTO getById(int id){
        PacienteEntity pacienteEntity = pacienteRepository.findById(id).get();
        PacienteDTO pacienteDTO = new PacienteDTO(pacienteEntity);
        return pacienteDTO;
    }

    public List<PacienteDTO> getByAll(){
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();
        List<PacienteEntity> pacienteEntityList = pacienteRepository.findAll();
        for (PacienteEntity pacienteEntity: pacienteEntityList) {
            PacienteDTO pacienteDTO= new PacienteDTO(pacienteEntity);
            pacienteDTOList.add(pacienteDTO);
        }
        return pacienteDTOList;
    }

    public String delete(int id){
        pacienteRepository.deleteById(id);
        return "O Paciente " + id + " foi deletado com sucesso!";
    }

    public PacienteDTO update(int id, PacienteDTO pacienteDTO){
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        pacienteEntity.setId(id);
        pacienteRepository.saveAndFlush(pacienteEntity);
        PacienteDTO pacienteDTO1 = new PacienteDTO(pacienteEntity);
        return pacienteDTO1;
    }
}
