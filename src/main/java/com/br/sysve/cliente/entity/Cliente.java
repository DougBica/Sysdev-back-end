package com.br.sysve.cliente.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.br.sysve.interfaces.CadastroGenerico;

import lombok.Data;

@Entity
@Table(name="cliente")
@Data
public class Cliente extends CadastroGenerico{
	@Id 
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String cpf;
	private String identificacao;
	private String sexo;
	private TipoCliente tipoCliente;

}
