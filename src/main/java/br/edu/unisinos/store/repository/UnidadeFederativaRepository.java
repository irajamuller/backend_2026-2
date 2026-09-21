package br.edu.unisinos.store.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unisinos.store.model.UnidadeFederativa;

@Repository
public interface UnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, UUID> {
	List<UnidadeFederativa> findBySigla(String sigla);
}
