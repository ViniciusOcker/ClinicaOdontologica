package Grupo3.IntegradoraFinal.service;

import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import Grupo3.IntegradoraFinal.repository.FuncionarioRepository;
import Grupo3.IntegradoraFinal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public PacienteDTO create(PacienteDTO pacienteDTO){
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        PacienteEntity pacienteEntity1 = pacienteRepository.create(pacienteEntity);
        PacienteDTO pacienteDTO1 = new PacienteDTO(pacienteEntity1);

        return pacienteDTO1;
    }

    public PacienteDTO getById(int id){
        PacienteEntity pacienteEntity = pacienteRepository.getById(id);
        PacienteDTO pacienteDTO = new PacienteDTO(pacienteEntity);
        return pacienteDTO;
    }

    public List<PacienteDTO> getByAll(){
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();
        List<PacienteEntity> pacienteEntityList = pacienteRepository.getByAll();
        for (PacienteEntity pacienteEntity: pacienteEntityList) {
            PacienteDTO pacienteDTO= new PacienteDTO(pacienteEntity);
            pacienteDTOList.add(pacienteDTO);
        }
        return pacienteDTOList;
    }

    public String delete(int id){
        pacienteRepository.delete(id);
        return "O Funcionario " + id + " foi deletado com sucesso!";
    }

    public PacienteDTO update(int id, PacienteDTO pacienteDTO){
        PacienteEntity pacienteEntity = new PacienteEntity(pacienteDTO);
        pacienteEntity.setId(id);
        pacienteRepository.update(pacienteEntity);
        PacienteDTO pacienteDTO1 = new PacienteDTO(pacienteEntity);
        return pacienteDTO1;
    }
}
