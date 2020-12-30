package com.br.sysve.entrada.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.sysve.dtos.EntradaDto;
import com.br.sysve.entrada.entity.enumerator.StatusEntrada;
import com.br.sysve.entrada.entity.enumerator.TipoEntrada;
import com.br.sysve.entrada_produto.EntradaProduto;
import com.br.sysve.interfaces.CadastroGenerico;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="entrada")
@Data
public class Entrada extends CadastroGenerico{
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "entrada")
	private Set<EntradaProduto> entradaProdutos;
	private BigDecimal valorTotal;
	private BigDecimal desconto;
	private LocalDate dataEntrada;	
	private TipoEntrada tipoEntrada;
	private StatusEntrada statusEntrada;
	
	
	public static Entrada dtoToClass(EntradaDto entradaDto, Entrada ent, Set<EntradaProduto> listaEntradaProduto) {	
		ent.setEntradaProdutos(listaEntradaProduto);
		ent.setValorTotal(entradaDto.getValorTotal());
		ent.setDesconto(entradaDto.getDesconto());
		ent.setAtivo(entradaDto.getAtivo());
		ent.setDataEntrada(LocalDate.now());
		ent.setTipoEntrada(TipoEntrada.getEnumFromIndex(entradaDto.getTipoEntrada()));
		ent.setStatusEntrada(StatusEntrada.getEnumFromIndex(entradaDto.getStatusEntrada()));
		if (ent.getId() != null) {
			ent.setDataEntrada(entradaDto.getDataEntrada());
			ent.setDataEdicao(LocalDate.now());
			// TODO alterar para pegar corretamente o id do usuario
			ent.setUsuarioEdicao((long) 1);
			ent.setVersao(ent.getVersao() + 1);
		}
		return ent;
	}
	
}
