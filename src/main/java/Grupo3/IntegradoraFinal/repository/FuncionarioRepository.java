package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.dto.FuncionarioDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FuncionarioRepository {
    private Map<Integer,FuncionarioEntity> funcionarios = new HashMap<>();
    int id = 1;

    public FuncionarioEntity create(FuncionarioEntity funcionarioEntity){
        return funcionarios.put(id++,funcionarioEntity);
    }

    public void delete(int id){
        funcionarios.remove(id);
    }

    public FuncionarioEntity getById(int id){
        return funcionarios.get(id);
    }

    public List<FuncionarioEntity> getByAll(){

        return new ArrayList<FuncionarioEntity>(funcionarios.values());
    }

    public FuncionarioEntity update(FuncionarioEntity funcionarioEntity){
        return funcionarios.put(funcionarioEntity.getId(),funcionarioEntity);
    }
}
