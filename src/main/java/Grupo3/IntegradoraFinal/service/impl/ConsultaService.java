package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import Grupo3.IntegradoraFinal.repository.IConsultaRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Grupo3.IntegradoraFinal.entity.dto.ConsultaDTO;

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

    @Override
    public ConsultaDTO create(ConsultaDTO consultaDTO) {
        return null;
    }

    @Override
    public ConsultaDTO getById(int id) {
        return null;
    }

    @Override
    public List<ConsultaDTO> getByAll() {
        return null;
    }

    @Override
    public String delete(int id) {
        return null;
    }

    @Override
    public ConsultaDTO update(int id, ConsultaDTO consultaDTO) {
        return null;
    }
}
