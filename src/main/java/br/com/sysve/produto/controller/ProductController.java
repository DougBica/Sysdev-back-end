package br.com.sysve.produto.controller;

import br.com.sysve.exception.ResourceNotFoundException;
import br.com.sysve.produto.dto.ProductDto;
import br.com.sysve.produto.dto.Unidade;
import br.com.sysve.produto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@CrossOrigin
@RequestMapping("api/public")
public class ProductController {
	
	@Autowired
	ProductService produtoService;
	
	@GetMapping("/produto")
	public ResponseEntity<List<ProductDto>>getAllProdutos(){
		return ResponseEntity.ok().body(produtoService.getAll());
		
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<ProductDto> getProduto(@PathVariable(value="id") UUID id) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(produtoService.getOne(id));		
	}

	

	
	@GetMapping("/listar-unidades")
	public ResponseEntity<List<Unidade>> listarUnidade() throws ResourceNotFoundException{
		return ResponseEntity.ok().body(produtoService.listarUnidade());		
	}
}
