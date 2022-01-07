package br.com.sysve.produto.service;

import br.com.sysve.entities.product.Product;
import br.com.sysve.exception.ResourceNotFoundException;
import br.com.sysve.produto.dto.ProductDto;
import br.com.sysve.produto.dto.Unidade;
import br.com.sysve.produto.repository.ProductRepository;
import br.com.sysve.produto.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository produtoRepository;
	
	@Autowired
	UnidadeRepository unidadeRepository;
	
	public List<ProductDto> getAll(){
		//return produtoRepository.findAll();
		return null;
	}

	public ProductDto getOne(UUID id) throws ResourceNotFoundException {
		Product product = produtoRepository.findById(id).orElseThrow(() ->
			new ResourceNotFoundException("Produto not found for this id :: " + id ));
		return new ProductDto(product.getUuid(), product.getVersion(), product.isActive(), product.getName(),
				product.getQuantity(), product.getUnitValue(), product.getBarCode(), product.getImagePath());
	}
	



	public List<Unidade> listarUnidade() {		
		return unidadeRepository.findAll();
	}
}
