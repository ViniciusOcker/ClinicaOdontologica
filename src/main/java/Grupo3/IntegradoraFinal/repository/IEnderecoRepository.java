package Grupo3.IntegradoraFinal.repository;

import Grupo3.IntegradoraFinal.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
