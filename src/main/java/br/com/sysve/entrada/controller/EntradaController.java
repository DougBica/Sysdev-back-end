package br.com.sysve.entrada.controller;

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

import br.com.sysve.dtos.EntradaDto;
import br.com.sysve.entrada.entity.Entrada;
import br.com.sysve.entrada.service.EntradaService;
import br.com.sysve.exception.ResourceNotFoundException;

@Controller
@RequestMapping("api/public")
public class EntradaController {
	
	@Autowired
	EntradaService entradaService;
	
	@GetMapping("/entrada")
	public ResponseEntity<List<Entrada>>getAllEntradas(){
		return ResponseEntity.ok().body(entradaService.getAll());
		
	}
	
	@GetMapping("/entrada/{id}")
	public ResponseEntity<Entrada> getProduto(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(entradaService.getOne(id));
		
	}
	
	@PostMapping("/entrada")
	public ResponseEntity<Entrada> criarProduto(@Validated @RequestBody EntradaDto entradaDto) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(entradaService.criarEditarEntrada(entradaDto));		
	}

}
