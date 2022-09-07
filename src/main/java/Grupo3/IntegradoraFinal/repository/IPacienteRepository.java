package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
