package br.com.sysve.produto.entity;

import br.com.sysve.dtos.ProdutoDto;
import br.com.sysve.entity.EntradaProduto;
import br.com.sysve.interfaces.CadastroGenerico;
import br.com.sysve.entity.SaidaProduto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

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
	@JsonIgnore
	private Set<EntradaProduto> entradaProdutos;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "produto")
	@JsonIgnore
	private Set<SaidaProduto> saidasProdutos; 
	
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