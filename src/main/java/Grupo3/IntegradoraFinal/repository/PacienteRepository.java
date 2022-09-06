package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*@Repository
public class PacienteRepository {
    private Map<Integer, PacienteEntity> pacientes = new HashMap<>();
    int id = 1;

    public PacienteEntity create(PacienteEntity pacienteEntity){
        return pacientes.put(id++,pacienteEntity);
    }

    public void delete(int id){
        pacientes.remove(id);
    }

    public PacienteEntity getById(int id){
        return pacientes.get(id);
    }

    public List<PacienteEntity> getByAll(){
        return new ArrayList<PacienteEntity>(pacientes.values());
    }

    public PacienteEntity update(PacienteEntity pacienteEntity){
        return pacientes.put(pacienteEntity.getId(),pacienteEntity);
    }
}
*/