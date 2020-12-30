package com.br.sysve.saida.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.sysve.dtos.SaidaDto;
import com.br.sysve.interfaces.CadastroGenerico;
import com.br.sysve.saida.entity.enumerator.StatusSaida;
import com.br.sysve.saida.entity.enumerator.TipoSaida;
import com.br.sysve.saida_produto.entity.SaidaProduto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="saida")
@Data
public class Saida extends CadastroGenerico{
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "saida_id")	
	private Set<SaidaProduto> saidaProdutos;
	private BigDecimal valorTotal;
	private BigDecimal desconto;
	private LocalDate dataEntrada;	
	private TipoSaida tipoEntrada;
	private StatusSaida statusEntrada;
	
	
	public static Saida dtoToClass(SaidaDto saidaDto, Saida s, Set<SaidaProduto> listaSaidaProduto) {	
		s.setSaidaProdutos(listaSaidaProduto);
		s.setValorTotal(saidaDto.getValorTotal());
		s.setDesconto(saidaDto.getDesconto());
		s.setAtivo(saidaDto.getAtivo());
		s.setDataEntrada(LocalDate.now());
		s.setTipoEntrada(TipoSaida.getEnumFromIndex(saidaDto.getTipoEntrada()));
		s.setStatusEntrada(StatusSaida.getEnumFromIndex(saidaDto.getStatusEntrada()));
		if (s.getId() != null) {
			s.setDataEntrada(saidaDto.getDataEntrada());
			s.setDataEdicao(LocalDate.now());
			// TODO alterar para pegar corretamente o id do usuario
			s.setUsuarioEdicao((long) 1);
			s.setVersao(s.getVersao() + 1);
		}
		return s;
	}
	

}
