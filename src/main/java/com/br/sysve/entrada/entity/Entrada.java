package com.br.sysve.entrada.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.sysve.entrada.entity.enumerator.StatusEntrada;
import com.br.sysve.entrada.entity.enumerator.TipoEntrada;
import com.br.sysve.entrada_produto.EntradaProduto;
import com.br.sysve.interfaces.CadastroGenerico;
import com.br.sysve.produto.entity.Produto;
import com.br.sysve.saida_produto.entity.SaidaProduto;

import lombok.Data;

@Entity
@Table(name="entrada")
@Data
public class Entrada extends CadastroGenerico{
	
	@OneToMany(mappedBy = "entrada")
	private Set<EntradaProduto> entradaProdutos;
	private BigDecimal valorTotal;
//	
//	
//	private TipoEntrada tipoEntrada;
//	private StatusEntrada statusEntrada;
//	
	
	

}
