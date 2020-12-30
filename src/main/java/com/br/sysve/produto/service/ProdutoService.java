package com.br.sysve.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sysve.dtos.ProdutoDto;
import com.br.sysve.exception.ResourceNeedBeUniqueException;
import com.br.sysve.exception.ResourceNotFoundException;
import com.br.sysve.produto.entity.Produto;
import com.br.sysve.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> getAll(){
		return produtoRepository.findAll();
	}

	public Produto getOne(Long id) throws ResourceNotFoundException {
		return produtoRepository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Produto not found for this id :: " + id ));
	}
	
	public Produto criarEditarProduto(ProdutoDto produtoDto) throws ResourceNotFoundException, ResourceNeedBeUniqueException {
		Produto prod = new Produto();
		if (produtoDto.getId() != null) 		
			prod = produtoRepository.findById(produtoDto.getId()).orElseThrow(() -> 
				new ResourceNotFoundException("Produto not found for this id :: " + produtoDto.getId()));
		else {			
			prod = produtoRepository.findByCodigoBarraAndAtivo(produtoDto.getCodigoBarra(), true).orElse(null);
			if (prod != null)
				throw new ResourceNeedBeUniqueException("Produto ja cadastrado com este código de barras");
		}
		
		prod = Produto.dtoToClass(produtoDto, prod);
		return produtoRepository.saveAndFlush(prod);
	}

	public Produto findByCodigoBarra(ProdutoDto produtoDto) throws ResourceNotFoundException {
		return produtoRepository.findByCodigoBarraAndAtivo(produtoDto.getCodigoBarra(), true).orElseThrow(() -> 
			new ResourceNotFoundException("Produto not found for this codigo de barra :: " + produtoDto.getCodigoBarra()));		 
	}
}
