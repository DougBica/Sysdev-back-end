package com.br.sysve.interfaces;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class CadastroGenerico{
	@Id 
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	private UUID uuid;
	private LocalDate dataCadastro;
	private LocalDate dataEdicao;
	private Long usuarioEdicao;
	private Integer versao;
	private Boolean ativo;
	
}
