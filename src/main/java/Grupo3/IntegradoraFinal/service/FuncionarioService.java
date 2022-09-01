package Grupo3.IntegradoraFinal.service;


import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import Grupo3.IntegradoraFinal.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public FuncionarioDTO create(FuncionarioDTO funcionarioDTO){
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionarioDTO);
        FuncionarioEntity funcionarioEntity1 = funcionarioRepository.create(funcionarioEntity);
        FuncionarioDTO funcionarioDTO1 = new FuncionarioDTO(funcionarioEntity1);

        return funcionarioDTO1;
    }

    public FuncionarioDTO getById(int id){
        FuncionarioEntity funcionarioEntity = funcionarioRepository.getById(id);
        FuncionarioDTO funcionarioDTO1 = new FuncionarioDTO(funcionarioEntity);
        return funcionarioDTO1;
    }

    public List<FuncionarioDTO> getByAll(){
        List<FuncionarioDTO> funcionarioDTOList = new ArrayList<>();
        List<FuncionarioEntity> funcionarioEntityList = funcionarioRepository.getByAll();
        for (FuncionarioEntity funcionarioEntity: funcionarioEntityList) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionarioEntity);
            funcionarioDTOList.add(funcionarioDTO);
        }
        return funcionarioDTOList;
    }

    public String delete(int id){
        funcionarioRepository.delete(id);
        return "O Funcionario " + id + " foi deletado com sucesso!";
    }

    public FuncionarioDTO update(int id, FuncionarioDTO funcionarioDTO){
        FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionarioDTO);
        funcionarioEntity.setId(id);
        funcionarioRepository.update(funcionarioEntity);
        FuncionarioDTO funcionarioDTO1 = new FuncionarioDTO(funcionarioEntity);
        return funcionarioDTO1;
    }
}
