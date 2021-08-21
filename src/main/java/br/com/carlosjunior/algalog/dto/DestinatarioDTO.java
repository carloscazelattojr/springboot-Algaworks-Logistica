package br.com.carlosjunior.algalog.dto;

import br.com.carlosjunior.algalog.entities.Destinatario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

 
@Getter
@Setter
public class DestinatarioDTO {
	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;

 

}
