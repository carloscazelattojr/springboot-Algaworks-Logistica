package br.com.carlosjunior.algalog.commons;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.carlosjunior.algalog.dto.EntregaDTO;
import br.com.carlosjunior.algalog.dto.input.EntregaInputDTO;
import br.com.carlosjunior.algalog.entities.Entrega;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {

	private ModelMapper modelMapper;

	public EntregaDTO toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	};

	public List<EntregaDTO> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream().map(this::toModel).collect(Collectors.toList());
	}

	public Entrega toEntity(EntregaInputDTO entregaInputDTO) {
		return modelMapper.map(entregaInputDTO, Entrega.class);
	}
	
}
