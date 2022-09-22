package Grupo3.IntegradoraFinal.repository;
import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import Grupo3.IntegradoraFinal.entity.dto.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Long> {
    @Query(value="SELECT * FROM Dentista WHERE nome LIKE ?1 AND sobrenome LIKE ?2", nativeQuery=true)
    Optional<List<DentistaEntity>> findNameFull(String nome, String sobrenome);
}
