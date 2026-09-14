package br.edu.unisinos.store.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.unisinos.store.model.UnidadeFederativa;

@Repository
public class UnidadeFederativaRepository {

	private List<UnidadeFederativa> items = new ArrayList<>();
	
	public UnidadeFederativaRepository() {
		UnidadeFederativa uf1 = UnidadeFederativa.builder()
				.id(UUID.randomUUID()).nome("Rio Grande do Sul").sigla("RS")
				.build();

		UnidadeFederativa uf2 = UnidadeFederativa.builder()
				.id(UUID.randomUUID()).nome("São Paulo").sigla("SP")
				.build();
		UnidadeFederativa uf3 = UnidadeFederativa.builder()
				.id(UUID.randomUUID()).nome("Santa Catarina").sigla("SC")
				.build();

		items.add(uf1);
		items.add(uf2);
		items.add(uf3);
	}

	public List<UnidadeFederativa> getAll() {
		return items;
	}

	public UnidadeFederativa getOne(UUID id) {
		return items.stream().filter(o -> o.getId().equals(id)).findFirst().get();
	}

	public void save(UnidadeFederativa unidadeFederativa) {
		unidadeFederativa.setId(UUID.randomUUID());
		items.add(unidadeFederativa);
	}
	
}
