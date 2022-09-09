package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {

}
