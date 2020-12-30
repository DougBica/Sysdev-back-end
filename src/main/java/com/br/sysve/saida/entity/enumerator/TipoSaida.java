package com.br.sysve.saida.entity.enumerator;

public enum TipoSaida {
	GERAL
	;
	
	public static TipoSaida getEnumFromIndex(String number) {
		return TipoSaida.values()[Integer.valueOf(number)];
	}

}
