package br.com.sysve.entrada.controller;

import br.com.sysve.entrada.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/public")
public class EntradaController {
	
	@Autowired
	EntradaService entradaService;
//
//	@GetMapping("/entrada")
//	public ResponseEntity<List<Entrada>>getAllEntradas(){
//		return ResponseEntity.ok().body(entradaService.getAll());
//
//	}
//
//	@GetMapping("/entrada/{id}")
//	public ResponseEntity<Entrada> getProduto(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
//		return ResponseEntity.ok().body(entradaService.getOne(id));
//
//	}
//
//	@PostMapping("/entrada")
//	public ResponseEntity<Entrada> criarProduto(@Validated @RequestBody EntradaDto entradaDto) throws ResourceNotFoundException{
//		return ResponseEntity.ok().body(entradaService.criarEditarEntrada(entradaDto));
//	}

}
