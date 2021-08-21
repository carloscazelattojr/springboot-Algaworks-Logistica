package br.com.carlosjunior.algalog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlosjunior.algalog.entities.Entrega;
import br.com.carlosjunior.algalog.repositories.EntregaRepository;
import br.com.carlosjunior.algalog.services.EntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository repository;
	private EntregaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return service.solicitar(entrega);
	}

	@GetMapping
	public List<Entrega> listar(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Entrega> buscar(@PathVariable Long id){
		return repository.findById(id).map(entrega -> ResponseEntity.ok(entrega))
				.orElse(ResponseEntity.notFound().build());
	}	
	
}
