package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.repository.IConsultaRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService implements IService<ConsultaDTO> {
    @Autowired
    IConsultaRepository consultaRepository;

    private ConsultaEntity mapperDTOToEntity(ConsultaDTO consultaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaEntity consulta = objectMapper.convertValue(consultaDTO, ConsultaEntity.class);
        return consulta;
    }

    private ConsultaDTO mapperEntityToDTO(ConsultaEntity consultaEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        ConsultaDTO consulta = objectMapper.convertValue(consultaEntity, ConsultaDTO.class);
        return consulta;
    }

    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        return null;
    }

    @Override
    public ConsultaDTO getById(Long id) {
        return mapperEntityToDTO(consultaRepository.findById(id).get());
    }

    @Override
    public List<ConsultaDTO> getByAll() {
        List<ConsultaDTO> consultaList = new ArrayList<>();
        for (ConsultaEntity consulta : consultaRepository.findAll()) {
            consultaList.add(mapperEntityToDTO(consulta));
        }
        return consultaList;
    }

    @Override
    public String delete(Long id) {
        consultaRepository.delete(new ConsultaEntity(id));
        return "A consulta " + id + " foi deletada comsucesso!";
    }

    @Override
    public ConsultaDTO update(Long id, ConsultaDTO consultaDTO) {
        return null;
    }
}
