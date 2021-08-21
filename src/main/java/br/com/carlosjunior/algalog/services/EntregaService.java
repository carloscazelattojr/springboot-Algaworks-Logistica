package br.com.carlosjunior.algalog.services;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.carlosjunior.algalog.entities.Cliente;
import br.com.carlosjunior.algalog.entities.Entrega;
import br.com.carlosjunior.algalog.entities.StatusEntrega;
import br.com.carlosjunior.algalog.exceptions.NegocioException;
import br.com.carlosjunior.algalog.repositories.ClienteRepository;
import br.com.carlosjunior.algalog.repositories.EntregaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntregaService {

	private EntregaRepository entregaRepository;
	private ClienteService clienteService;
	

	@Transactional
	public Entrega solicitar(Entrega entrega) {

		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());	
				
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());

		return entregaRepository.save(entrega);
	}

}
