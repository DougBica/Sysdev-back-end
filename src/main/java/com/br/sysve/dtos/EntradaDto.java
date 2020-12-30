package com.br.sysve.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import lombok.Data;

@Data
public class EntradaDto {
	private Long id;
	private Set<EntradaProdutoDto> entradaProdutos;
	private BigDecimal valorTotal;
	private BigDecimal desconto;
	private LocalDate dataEntrada;	
	private String tipoEntrada;
	private String statusEntrada;
	private Boolean ativo;

}
