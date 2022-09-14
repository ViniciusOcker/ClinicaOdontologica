package Grupo3.IntegradoraFinal.service.impl;

import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.CriarDentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.DentistaDTO;
import Grupo3.IntegradoraFinal.entity.dto.UsuarioDTO;
import Grupo3.IntegradoraFinal.repository.IDentistaRepository;
import Grupo3.IntegradoraFinal.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistaService implements IService<DentistaDTO> {
    @Autowired
    IDentistaRepository dentistaRepository;
    @Autowired
    UsuarioService usuarioService;

    private DentistaEntity mapperDTOToEntity(DentistaDTO dentistaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaEntity dentista = objectMapper.convertValue(dentistaDTO, DentistaEntity.class);
        return dentista;
    }

    private DentistaDTO mapperEntityToDTO(DentistaEntity dentistaEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaDTO dentista = objectMapper.convertValue(dentistaEntity, DentistaDTO.class);
        return dentista;
    }

    public DentistaDTO create (CriarDentistaDTO criarDentistaDTO) {
        return mapperEntityToDTO(dentistaRepository.saveAndFlush(new DentistaEntity(criarDentistaDTO)));
    }

    @Override
    public DentistaDTO getById(Long id) {
        return mapperEntityToDTO(dentistaRepository.findById(id).get());
    }

    @Override
    public List<DentistaDTO> getByAll() {
        List<DentistaDTO> dentistaList = new ArrayList<>();
        for (DentistaEntity dentista:dentistaRepository.findAll()) {
            dentistaList.add(mapperEntityToDTO(dentista));
        }
        return dentistaList;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public DentistaDTO update(Long id, DentistaDTO dentistaDTO) {
        return null;
    }
}
