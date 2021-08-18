package br.com.carlosjunior.algalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carlosjunior.algalog.entities.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{

}
