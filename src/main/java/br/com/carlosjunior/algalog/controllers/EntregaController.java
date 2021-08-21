package br.com.carlosjunior.algalog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.carlosjunior.algalog.commons.EntregaAssembler;
import br.com.carlosjunior.algalog.dto.EntregaDTO;
import br.com.carlosjunior.algalog.dto.input.EntregaInputDTO;
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
	private EntregaAssembler entregaAssambler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInputDTO entrega) {
		Entrega novaEntrega = entregaAssambler.toEntity(entrega);
		Entrega entregaSolicitada = service.solicitar(novaEntrega);
		return entregaAssambler.toModel(entregaSolicitada);
	}

	@GetMapping
	public List<EntregaDTO> listar() {
		return entregaAssambler.toCollectionModel(repository.findAll());
	}

	@GetMapping("/{id}")
	private ResponseEntity<EntregaDTO> buscar(@PathVariable Long id) {
		return repository.findById(id).map(entrega -> ResponseEntity.ok(entregaAssambler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}

}
