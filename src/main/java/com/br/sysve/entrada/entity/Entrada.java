package com.br.sysve.entrada.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.br.sysve.entrada.entity.enumerator.StatusEntrada;
import com.br.sysve.entrada.entity.enumerator.TipoEntrada;
import com.br.sysve.interfaces.CadastroGenerico;
import com.br.sysve.produto.entity.Produto;

import lombok.Data;

@Entity
@Table(name="entrada")
@Data
public class Entrada extends CadastroGenerico{
	
	@ManyToMany
	private Produto produto;
	private BigDecimal valorTotal;
	private TipoEntrada tipoEntrada;
	private StatusEntrada statusEntrada;
	
	
	

}
