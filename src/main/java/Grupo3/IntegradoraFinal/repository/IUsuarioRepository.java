package Grupo3.IntegradoraFinal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<IUsuarioRepository, Long> {
}
