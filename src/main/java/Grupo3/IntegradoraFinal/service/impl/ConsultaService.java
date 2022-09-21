package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarConsultaDTO;
import Grupo3.IntegradoraFinal.repository.IConsultaRepository;
import Grupo3.IntegradoraFinal.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService implements IService<ConsultaDTO> {
    @Autowired
    IConsultaRepository consultaRepository;

    public ConsultaDTO create(CriarConsultaDTO criarConsultaDTO) {
        return new ConsultaDTO(consultaRepository.saveAndFlush(new ConsultaEntity(criarConsultaDTO)));
    }

    @Override
    public ConsultaDTO getById(Long id) {
        return new ConsultaDTO(consultaRepository.findById(id).get());
    }

    @Override
    public List<ConsultaDTO> getByAll() {
        List<ConsultaDTO> consultaList = new ArrayList<>();
        for (ConsultaEntity consulta : consultaRepository.findAll()) {
            consultaList.add(new ConsultaDTO(consulta));
        }
        return consultaList;
    }

    @Override
    public String delete(Long id) {
        consultaRepository.deleteById(id);
        return "A consulta " + id + " foi deletada com sucesso!";
    }

    public ConsultaDTO update(Long id, CriarConsultaDTO criarConsultaDTO) {
        ConsultaEntity consultaEntity = new ConsultaEntity(criarConsultaDTO);
        consultaEntity.setIdConsulta(id);
        return new ConsultaDTO(consultaRepository.saveAndFlush(consultaEntity));
    }

    public List<ConsultaDTO> getByIdDentista(Long id) {
        List<ConsultaDTO> consultaList = new ArrayList<>();
        for (ConsultaEntity consulta : consultaRepository.getByIdDentista(id).get()) {
            consultaList.add(new ConsultaDTO(consulta));
        }
        return consultaList;
    }

    public List<ConsultaDTO> getByIdPaciente(Long id) {
        List<ConsultaDTO> consultaList = new ArrayList<>();
        for (ConsultaEntity consulta : consultaRepository.getByIdPaciente(id).get()) {
            consultaList.add(new ConsultaDTO(consulta));
        }
        return consultaList;
    }
}
