package com.br.sysve.interfaces;

import java.io.Serializable;
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
	private boolean ativo;
	
//	private CadastroGenerico() {
//		if (this.uuid == null) {
//			this.uuid = UUID.randomUUID();
//		}
//		if (this.dataCadastro == null) {
//			this.dataCadastro = LocalDate.now();
//		}
//		if (this.dataEdicao == null) {
//			this.dataEdicao = LocalDate.now();
//		}
//	}
}
