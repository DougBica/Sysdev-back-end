package br.com.sysve.saida.controller;

import br.com.sysve.saida.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/public")
public class SaidaController {
	
	@Autowired
	SaidaService saidaService;
	
//	@GetMapping("/saida")
//	public ResponseEntity<List<Saida>>getAllEntradas(){
//		return ResponseEntity.ok().body(saidaService.getAll());
//
//	}
//
//	@GetMapping("/saida/{id}")
//	public ResponseEntity<Saida> getProduto(@PathVariable(value="id") Long id) throws ResourceNotFoundException{
//		return ResponseEntity.ok().body(saidaService.getOne(id));
//
//	}
//
//	@PostMapping("/saida")
//	public ResponseEntity<Saida> criarProduto(@Validated @RequestBody SaidaDto saidaDto) throws ResourceNotFoundException{
//		return ResponseEntity.ok().body(saidaService.criarEditarSaida(saidaDto));
//	}

}
