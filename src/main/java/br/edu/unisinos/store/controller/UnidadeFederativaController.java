package br.edu.unisinos.store.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unisinos.store.model.UnidadeFederativa;
import br.edu.unisinos.store.service.UnidadeFederativaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CRUD Unidade Federativa", description = "Cadastro das unidades federativas do Brasil")
@RestController
@RequestMapping("/unidade-federativa")
public class UnidadeFederativaController {

	@Autowired
	private UnidadeFederativaService unidadeFederativaService;
	
	@Operation(description = "Retorna todas as unidades federativas cadastradas")
	@ApiResponse(description = "Lista das unidades federativas", content = @Content(mediaType = "application/json"))
	@GetMapping
	public List<UnidadeFederativa> getAll() {
		return unidadeFederativaService.getAll(); 
	}
	
	@GetMapping("/{id}")
	public UnidadeFederativa getOne(@PathVariable UUID id) {
		return unidadeFederativaService.getOne(id);
	}
	
	@PostMapping
	public void save(@RequestBody UnidadeFederativa unidadeFederativa) {
		unidadeFederativaService.save(unidadeFederativa);
	}
}
