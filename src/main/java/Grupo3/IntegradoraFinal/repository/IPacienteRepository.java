package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteEntity, Long> {

    @Query(value="SELECT * FROM Paciente WHERE nome LIKE ?1 AND sobrenome LIKE ?2", nativeQuery=true)
    List<PacienteEntity> findNameFull(String nome, String sobrenome);
}
