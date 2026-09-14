package br.edu.unisinos.store.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unisinos.store.model.UnidadeFederativa;
import br.edu.unisinos.store.repository.UnidadeFederativaRepository;

@Service
public class UnidadeFederativaService {

	@Autowired
	private UnidadeFederativaRepository unidadeFederativaRepository;
	
	public List<UnidadeFederativa> getAll() {
		return unidadeFederativaRepository.getAll();
	}
	
	public UnidadeFederativa getOne(UUID id) {
		return unidadeFederativaRepository.getOne(id);
	}
	
	public void save(UnidadeFederativa unidadeFederativa) {
		unidadeFederativaRepository.save(unidadeFederativa);
	}
}
