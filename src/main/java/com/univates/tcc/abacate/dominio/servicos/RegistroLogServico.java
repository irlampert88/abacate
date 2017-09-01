package com.univates.tcc.abacate.dominio.servicos;

import org.springframework.stereotype.Service;

import com.univates.tcc.abacate.dominio.agregadores.Acoes;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.RegistroLog;

@Service
public interface RegistroLogServico extends ServicoDeCrud<RegistroLog, Integer> {
	
	public <E extends EntidadeAbstrata<?>> void registrarLog(E entidade, Acoes acao);
}
