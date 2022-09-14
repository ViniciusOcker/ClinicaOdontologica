package Grupo3.IntegradoraFinal.repository;
import Grupo3.IntegradoraFinal.entity.DentistaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistaRepository extends JpaRepository<DentistaEntity, Long> {
}
