package br.com.sysve.saida.service;

import br.com.sysve.exception.ResourceNotFoundException;
import br.com.sysve.produto.repository.ProductRepository;
import br.com.sysve.saida.entity.Saida;
import br.com.sysve.saida.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaidaService {

	@Autowired
	SaidaRepository saidaRepository;
	
	@Autowired
	ProductRepository produtoRepository;
	
	public List<Saida> getAll(){
		return saidaRepository.findAll();
	}

	public Saida getOne(Long id) throws ResourceNotFoundException {
		return saidaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + id ));
	}
//
//	public Saida criarEditarSaida(SaidaDto saidaDto) throws ResourceNotFoundException {
//		Saida s = new Saida();
//		if (saidaDto.getId() != null)
//			s = saidaRepository.findById(saidaDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + saidaDto.getId()));
//
//		Set<SaidaProduto> listaSaidaProduto =  new  HashSet<SaidaProduto>();
//
//		for (SaidaProdutoDto spDto : saidaDto.getSaidaProdutos()) {
//			ProductDto p = new ProductDto();
//			SaidaProduto ep = new SaidaProduto();
//			ep.setSaida(s);
//			p = produtoRepository.findById(spDto.getIdProduto()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + spDto.getIdProduto()));
//			ep.setProduto(p);
//			ep.setQuantidadeProduto(spDto.getQuantidade());
//			ep.setValorUnitario(spDto.getValorUnitario());
//			listaSaidaProduto.add(ep);
//		}
//
//		s = Saida.dtoToClass(saidaDto, s, listaSaidaProduto );
//		return saidaRepository.save(s);
//	}
}
