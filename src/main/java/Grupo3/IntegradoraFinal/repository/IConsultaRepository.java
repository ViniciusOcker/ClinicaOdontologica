package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultaRepository extends JpaRepository<ConsultaEntity, Long> {
}
