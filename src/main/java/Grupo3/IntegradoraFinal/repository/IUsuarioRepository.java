package Grupo3.IntegradoraFinal.repository;
import Grupo3.IntegradoraFinal.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
