package com.br.sysve.saida.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sysve.dtos.SaidaDto;
import com.br.sysve.dtos.SaidaProdutoDto;
import com.br.sysve.exception.ResourceNotFoundException;
import com.br.sysve.produto.entity.Produto;
import com.br.sysve.produto.repository.ProdutoRepository;
import com.br.sysve.saida.entity.Saida;
import com.br.sysve.saida.repository.SaidaRepository;
import com.br.sysve.saida_produto.entity.SaidaProduto;

@Service
public class SaidaService {

	@Autowired
	SaidaRepository saidaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Saida> getAll(){
		return saidaRepository.findAll();
	}

	public Saida getOne(Long id) throws ResourceNotFoundException {
		return saidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + id ));
	}
	
	public Saida criarEditarSaida(SaidaDto saidaDto) throws ResourceNotFoundException {
		Saida s = new Saida();
		if (saidaDto.getId() != null) 		
			s = saidaRepository.findById(saidaDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + saidaDto.getId()));
		
		Set<SaidaProduto> listaSaidaProduto =  new  HashSet<SaidaProduto>();
		
		for (SaidaProdutoDto spDto : saidaDto.getSaidaProdutos()) {
			Produto p = new Produto();
			SaidaProduto ep = new SaidaProduto();
			ep.setSaida(s);
			p = produtoRepository.findById(spDto.getIdProduto()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + spDto.getIdProduto()));
			ep.setProduto(p);
			ep.setQuantidadeProduto(spDto.getQuantidade());
			ep.setValorUnitario(spDto.getValorUnitario());
			listaSaidaProduto.add(ep);
		}
		
		s = Saida.dtoToClass(saidaDto, s, listaSaidaProduto );
		return saidaRepository.save(s);
	}
}
