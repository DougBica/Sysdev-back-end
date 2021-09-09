package br.com.sysve.saida.entity.enumerator;

public enum StatusSaida {
	
	CRIADA, FINALIZADA ;
	
	public static StatusSaida getEnumFromIndex(String number) {
		return StatusSaida.values()[Integer.valueOf(number)];
	}

}
