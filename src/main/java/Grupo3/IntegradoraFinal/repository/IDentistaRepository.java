package Grupo3.IntegradoraFinal.repository;
import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Long> {
    @Query(value="SELECT CONCAT(nome,CONCAT(' ',sobrenome)) AS nomeCompleto FROM Dentista WHERE nomeCompleto LIKE ?1", nativeQuery=true)
    List<DentistaEntity> findNameFull(String nomeCompleto);
}
