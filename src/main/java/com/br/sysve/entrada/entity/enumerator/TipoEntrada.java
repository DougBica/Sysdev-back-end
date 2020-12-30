package com.br.sysve.entrada.entity.enumerator;

public enum TipoEntrada {
	GERAL
	;
	
	
	public static TipoEntrada getEnumFromIndex(String number) {
		return TipoEntrada.values()[Integer.valueOf(number)];
	}
	
}
