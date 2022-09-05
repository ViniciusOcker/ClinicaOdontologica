package Grupo3.IntegradoraFinal.repository;


import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EnderecoRepository {

    private Map<Integer, EnderecoEntity> enderecos = new HashMap<>();

    int id = 1;

    public EnderecoEntity create(EnderecoEntity enderecoEntity){
        return enderecos.put(id++,enderecoEntity);
    }

    public void delete(int id){
        enderecos.remove(id);
    }

    public EnderecoEntity getById(int id){
        return enderecos.get(id);
    }

    public List<EnderecoEntity> getByAll(){
        return new ArrayList<EnderecoEntity>(enderecos.values());
    }

    public EnderecoEntity update(EnderecoEntity enderecoEntity){
        return enderecos.put(enderecoEntity.getId(),enderecoEntity);
    }
}
