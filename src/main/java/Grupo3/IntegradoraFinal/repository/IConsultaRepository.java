package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Long> {
    @Query(value="SELECT * FROM consulta WHERE id_dentista LIKE ?1", nativeQuery=true)
    Optional<List<ConsultaEntity>> getByIdDentista(Long id);

    @Query(value="SELECT * FROM consulta WHERE id_paciente LIKE ?1", nativeQuery=true)
    Optional<List<ConsultaEntity>> getByIdPaciente(Long id);

    @Query(value="SELECT * FROM consulta WHERE id_dentista LIKE ?1 AND (inicioConsulta <= ?3 AND inicioConsulta <= ?2 ) AND (fimConsulta <= ?2 AND fimConsulta <= ?3 ) ", nativeQuery=true)
    Optional<List<ConsultaEntity>> getByConsultaData(Long id, LocalDateTime inicio, LocalDateTime fim);

}
