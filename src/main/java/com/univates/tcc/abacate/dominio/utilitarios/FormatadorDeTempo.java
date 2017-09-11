package com.univates.tcc.abacate.dominio.utilitarios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class FormatadorDeTempo {

	private FormatadorDeTempo() {
	}
	
	public static String formatoDataEHora(LocalDateTime dataEHora) {
		return dataEHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}
	
}
