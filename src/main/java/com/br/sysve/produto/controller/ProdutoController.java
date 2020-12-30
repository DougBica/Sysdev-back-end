package com.br.sysve.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.sysve.dtos.ProdutoDto;
import com.br.sysve.exception.ResourceNotFoundException;
import com.br.sysve.produto.entity.Produto;
import com.br.sysve.produto.service.ProdutoService;

@Controller
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
	public ResponseEntity<Produto> criarProduto(@Validated @RequestBody ProdutoDto produtoDto) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(produtoService.criarEditarProduto(produtoDto));		
	}
}
