package com.univates.tcc.abacate.aplicacao.rest.permissao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequerPermissao {
	
	public TipoDePermissao tipoDePermissao();
}