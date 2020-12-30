package com.br.sysve.entrada.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sysve.dtos.EntradaDto;
import com.br.sysve.dtos.EntradaProdutoDto;
import com.br.sysve.entrada.entity.Entrada;
import com.br.sysve.entrada.repository.EntradaRepository;
import com.br.sysve.entrada_produto.EntradaProduto;
import com.br.sysve.exception.ResourceNotFoundException;
import com.br.sysve.produto.entity.Produto;
import com.br.sysve.produto.repository.ProdutoRepository;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Entrada> getAll(){
		return entradaRepository.findAll();
	}

	public Entrada getOne(Long id) throws ResourceNotFoundException {
		return entradaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + id ));
	}
	
	public Entrada criarEditarEntrada(EntradaDto entradaDto) throws ResourceNotFoundException {
		Entrada ent = new Entrada();
		if (entradaDto.getId() != null) 		
			ent = entradaRepository.findById(entradaDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + entradaDto.getId()));
		
		Set<EntradaProduto> listaEntradaProduto =  new  HashSet<EntradaProduto>();
		
		for (EntradaProdutoDto epDto : entradaDto.getEntradaProdutos()) {
			Produto p = new Produto();
			EntradaProduto ep = new EntradaProduto();
			ep.setEntrada(ent);
			p = produtoRepository.findById(epDto.getIdProduto()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + epDto.getIdProduto()));
			ep.setProduto(p);
			ep.setQuantidadeProduto(epDto.getQuantidade());
			listaEntradaProduto.add(ep);
		}
		
		ent = Entrada.dtoToClass(entradaDto, ent, listaEntradaProduto );
		return entradaRepository.save(ent);
	}

}
