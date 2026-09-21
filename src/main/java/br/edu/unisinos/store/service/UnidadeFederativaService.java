package br.edu.unisinos.store.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unisinos.store.model.UnidadeFederativa;
import br.edu.unisinos.store.repository.UnidadeFederativaRepository;
import jakarta.transaction.Transactional;

@Service
public class UnidadeFederativaService {

	@Autowired
	private UnidadeFederativaRepository unidadeFederativaRepository;
	
	public List<UnidadeFederativa> getAll(String sigla) {
		if (sigla != null) {
			return unidadeFederativaRepository.findBySigla(sigla);
		}
		return unidadeFederativaRepository.findAll();
	}
	
	public UnidadeFederativa getOne(UUID id) {
		return unidadeFederativaRepository.findById(id).orElse(null);
	}
	
	public UnidadeFederativa save(UnidadeFederativa unidadeFederativa) {
		return unidadeFederativaRepository.save(unidadeFederativa);
	}
	
	public void delete(UUID id) {
		unidadeFederativaRepository.deleteById(id);
	}
	
}
