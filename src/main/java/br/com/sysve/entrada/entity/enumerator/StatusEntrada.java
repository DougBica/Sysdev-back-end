package br.com.sysve.entrada.entity.enumerator;

public enum StatusEntrada {
	RECEBIDO, ANALISADO, FINALIZADO;
	
	public static StatusEntrada getEnumFromIndex(String number) {
		return StatusEntrada.values()[Integer.valueOf(number)];
	}
}
