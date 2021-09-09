package br.com.sysve.dtos;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EntradaProdutoDto {
	private Long idProduto;
	private Long quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal custoUnitario;
}
