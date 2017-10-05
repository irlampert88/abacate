package com.univates.tcc.abacate.dominio.utilitarios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Table;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;

import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;

public class LocalizadorDeClasses {

	private LocalizadorDeClasses() {
	}

	public static <ENTIDADE extends EntidadeAbstrata<?>> Iterable<Class<ENTIDADE>> todasEntidades() {
		final Set<Class<ENTIDADE>> entidades = new HashSet<>();

		 for (Class<?> classeDoPacote : classesDoPacote(ConstantesDeConfiguracao.Pacotes.ENTIDADES)) {
			 if (classeForEntidadeValida(classeDoPacote)) {
				 entidades.add((Class<ENTIDADE>) classeDoPacote);
			 }
		 }

		return entidades;
	}

	private static boolean classeForEntidadeValida(Class<?> classeDoPacote) {
		if (!classeDoPacote.isAnnotationPresent(Table.class))
			return false;
			
		return true;
	}

	private static Iterable<Class<?>> classesDoPacote(String nomeDoPacote) {
		Reflections r = new Reflections(nomeDoPacote, new SubTypesScanner(false), ClasspathHelper.forClassLoader());
		Set<Class<?>> classes = r.getSubTypesOf(Object.class);
		return classes;
	}
}
