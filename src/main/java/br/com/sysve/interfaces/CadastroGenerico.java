package br.com.sysve.interfaces;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.data.annotation.LastModifiedDate;

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
	
	@LastModifiedDate
	private LocalDate dataEdicao;
	private Long usuarioEdicao;
	private Integer versao = 0;
	private Boolean ativo;
	
	
	public CadastroGenerico() {
		this.uuid = UUID.randomUUID();
		this.dataCadastro = LocalDate.now();
		this.dataEdicao = LocalDate.now();
		// TODO mudar no futuro
		this.usuarioEdicao = (long) 1;
		this.versao++;
		this.ativo = true;	
	}
}
