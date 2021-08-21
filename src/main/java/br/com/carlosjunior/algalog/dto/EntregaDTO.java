package br.com.carlosjunior.algalog.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import br.com.carlosjunior.algalog.entities.Entrega;
import br.com.carlosjunior.algalog.entities.StatusEntrega;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

 
@Getter
@Setter
public class EntregaDTO {

	private Long id;
	private ClienteResumoDTO cliente;
	private DestinatarioDTO destinatarioDTO;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
 
}
