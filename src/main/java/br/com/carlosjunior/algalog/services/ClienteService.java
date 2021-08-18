package br.com.carlosjunior.algalog.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carlosjunior.algalog.entities.Cliente;
import br.com.carlosjunior.algalog.exceptions.NegocioException;
import br.com.carlosjunior.algalog.repositories.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional
	public Cliente salvar(Cliente cliente) {

		boolean emailEmUso = repository.findByEmail(cliente.getEmail()).stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado para este e-mail.");
		}
		return repository.save(cliente);
	}

	public void excluir(Long id) {
		repository.deleteById(id);
	}

}
