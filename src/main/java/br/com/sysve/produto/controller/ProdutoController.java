package br.com.sysve.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.sysve.dtos.ProdutoDto;
import br.com.sysve.exception.ResourceNeedBeUniqueException;
import br.com.sysve.exception.ResourceNotFoundException;
import br.com.sysve.produto.entity.Produto;
import br.com.sysve.produto.entity.Unidade;
import br.com.sysve.produto.service.ProdutoService;

@Controller
@CrossOrigin
@RequestMapping("api/public")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>>getAllProdutos(){
		return ResponseEntity.ok().body(produtoService.getAll());
		
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> getProduto(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(produtoService.getOne(id));		
	}
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> criarProduto(@Validated @RequestBody ProdutoDto produtoDto) throws ResourceNotFoundException, ResourceNeedBeUniqueException{
		return ResponseEntity.ok().body(produtoService.criarEditarProduto(produtoDto));		
	}
	
	@PostMapping("/codigo-produto")
	public ResponseEntity<Produto> getProdutoByCodigoBarra(@Validated @RequestBody ProdutoDto produtoDto) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(produtoService.findByCodigoBarra(produtoDto));		
	}
	
	@GetMapping("/listar-unidades")
	public ResponseEntity<List<Unidade>> listarUnidade() throws ResourceNotFoundException{
		return ResponseEntity.ok().body(produtoService.listarUnidade());		
	}
}
