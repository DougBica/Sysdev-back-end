package com.br.sysve.saida.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.sysve.interfaces.CadastroGenerico;
import com.br.sysve.saida_produto.entity.SaidaProduto;

import lombok.Data;

@Entity
@Table(name="saida")
@Data
public class Saida extends CadastroGenerico{
	
	@OneToMany(mappedBy = "saida")
	private Set<SaidaProduto> saidasProdutos;
	private BigDecimal valorTotal;
	
	
//	private TipoSaida tipoEntrada;
//	private StatusSaida statusEntrada;
	

}
