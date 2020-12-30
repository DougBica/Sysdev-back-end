package com.br.sysve.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaidaProdutoDto {
	private Long idProduto;
	private Long quantidade;
	private BigDecimal valorUnitario;
}
