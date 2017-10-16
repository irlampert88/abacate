package com.univates.tcc.abacate.dominio.utilitarios;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;
import com.univates.tcc.abacate.dominio.agregadores.Foto;

public class LimparAtributoDoObjeto {

	public LimparAtributoDoObjeto() {
	}
	
	public void removerArquivosDaEntidade(Iterable<?> objetos) {
		try {
			Map<String, Object> mapa = new HashMap<>();
			for (Object objeto : objetos) {
				for (Field campo : objeto.getClass().getDeclaredFields()) {
					campo.setAccessible(true);
				
					if (campo.getType().getCanonicalName().startsWith(ConstantesDeConfiguracao.Pacotes.ENTIDADES)
							&& !mapa.containsKey(campo.get(objeto).toString())) {
						mapa.put(campo.get(objeto).toString(), objeto);
						new LimparAtributoDoObjeto().removerArquivosDaEntidade(Arrays.asList(campo.get(objeto)));
					}
					
					if (campo.isAnnotationPresent(Foto.class)) {
						try {
							campo.set(objeto, null);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
		 		}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
