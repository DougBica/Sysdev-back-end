package com.br.sysve.produto.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.sysve.dtos.ProdutoDto;
import com.br.sysve.interfaces.CadastroGenerico;

import lombok.Data;

@Entity
@Table(name="produto")
@Data
public class Produto extends CadastroGenerico{
	
	private String nome;
	private BigDecimal quantidadeEmbalagem;
	private Long codigoBarra;
	private String caminhoImagem;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Unidade unidade;
	
	public Produto() {
		super();
	}
	
	public static Produto dtoToClass(ProdutoDto produtoDto, Produto prod) {
		prod.setNome(produtoDto.getNome());
		prod.setQuantidadeEmbalagem(produtoDto.getQuantidadeEmbalagem());
		prod.setCodigoBarra(produtoDto.getCodigoBarra());
		prod.setCaminhoImagem(produtoDto.getCaminhoImagem());
		prod.setUnidade(produtoDto.getUnidade());
		prod.setAtivo(produtoDto.getAtivo());
		if (prod.getId() != null) {
			prod.setDataEdicao(LocalDate.now());
			// TODO alterar para pegar corretamente o id do usuario
			prod.setUsuarioEdicao((long) 1);
			prod.setVersao(prod.getVersao() + 1);
		}
		return prod;
	}
}
