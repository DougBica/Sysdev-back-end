package com.br.sysve.produto.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.sysve.dtos.ProdutoDto;
import com.br.sysve.entrada_produto.EntradaProduto;
import com.br.sysve.interfaces.CadastroGenerico;
import com.br.sysve.saida_produto.entity.SaidaProduto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="produto")
@Data
public class Produto extends CadastroGenerico{
	
	private String nome;
	private BigDecimal quantidadeEmbalagem;
	private BigDecimal valorVenda;
	private Long codigoBarra;
	private String caminhoImagem;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "produto")
	@JsonManagedReference
	private Set<EntradaProduto> entradaProdutos;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "produto")
	private Set<SaidaProduto> saidasProdutos; 
	
	@OneToOne(fetch = FetchType.EAGER)
	private Unidade unidade;
	
	public Produto() {
		super();
	}
	
	public Set<EntradaProduto> getEntradaProdutos(){
		return this.entradaProdutos;
	}
	public Set<SaidaProduto> getSaidaProdutos(){
		return this.saidasProdutos;
	}
	
	public static Produto dtoToClass(ProdutoDto produtoDto, Produto prod) {
		prod.setNome(produtoDto.getNome());
		prod.setQuantidadeEmbalagem(produtoDto.getQuantidadeEmbalagem());
		prod.setCodigoBarra(produtoDto.getCodigoBarra());
		prod.setCaminhoImagem(produtoDto.getCaminhoImagem());
		prod.setUnidade(produtoDto.getUnidade());
		prod.setAtivo(produtoDto.getAtivo());
		prod.setValorVenda(produtoDto.getValorVenda());
		if (prod.getId() != null) {
			prod.setDataEdicao(LocalDate.now());
			// TODO alterar para pegar corretamente o id do usuario
			prod.setUsuarioEdicao((long) 1);
			prod.setVersao(prod.getVersao() + 1);
		}
		return prod;
	}
}
