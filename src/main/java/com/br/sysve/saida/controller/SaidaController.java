package com.br.sysve.saida.controller;

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

import com.br.sysve.dtos.SaidaDto;
import com.br.sysve.exception.ResourceNotFoundException;
import com.br.sysve.saida.entity.Saida;
import com.br.sysve.saida.service.SaidaService;

@Controller
@RequestMapping("api/public")
public class SaidaController {
	
	@Autowired
	SaidaService saidaService;
	
	@GetMapping("/saida")
	public ResponseEntity<List<Saida>>getAllEntradas(){
		return ResponseEntity.ok().body(saidaService.getAll());
		
	}
	
	@GetMapping("/saida/{id}")
	public ResponseEntity<Saida> getProduto(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(saidaService.getOne(id));
		
	}
	
	@PostMapping("/saida")
	public ResponseEntity<Saida> criarProduto(@Validated @RequestBody SaidaDto saidaDto) throws ResourceNotFoundException{
		return ResponseEntity.ok().body(saidaService.criarEditarSaida(saidaDto));		
	}

}
