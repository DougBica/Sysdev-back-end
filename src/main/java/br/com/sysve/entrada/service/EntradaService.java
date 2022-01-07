package br.com.sysve.entrada.service;

import br.com.sysve.entrada.entity.Entrada;
import br.com.sysve.entrada.repository.EntradaRepository;
import br.com.sysve.exception.ResourceNotFoundException;
import br.com.sysve.produto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {

	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
    ProductRepository produtoRepository;
	
	public List<Entrada> getAll(){
		return entradaRepository.findAll();
	}

	public Entrada getOne(Long id) throws ResourceNotFoundException {
		return entradaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + id ));
	}
	
//	public Entrada criarEditarEntrada(EntradaDto entradaDto) throws ResourceNotFoundException {
//		Entrada ent = new Entrada();
//		if (entradaDto.getId() != null)
//			ent = entradaRepository.findById(entradaDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + entradaDto.getId()));
//
//		Set<EntradaProduto> listaEntradaProduto =  new  HashSet<EntradaProduto>();
//
//		for (EntradaProdutoDto epDto : entradaDto.getEntradaProdutos()) {
//			ProductDto p = new ProductDto();
//			EntradaProduto ep = new EntradaProduto();
//			ep.setEntrada(ent);
//			p = produtoRepository.findById(epDto.getIdProduto()).orElseThrow(() -> new ResourceNotFoundException("Entrada not found for this id :: " + epDto.getIdProduto()));
//			ep.setProduto(p);
//			ep.setQuantidadeProduto(epDto.getQuantidade());
//			listaEntradaProduto.add(ep);
//		}
//
//		ent = Entrada.dtoToClass(entradaDto, ent, listaEntradaProduto );
//		return entradaRepository.save(ent);
//	}

}
