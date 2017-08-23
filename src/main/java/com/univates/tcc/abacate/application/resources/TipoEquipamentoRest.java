package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.TipoEquipamento;
import com.univates.tcc.abacate.domain.repositories.TipoEquipamentoRepositorio;

@RestController
@RequestMapping("/tipos_equipamentos")
public class TipoEquipamentoRest extends AbstractCrudResource<TipoEquipamento, Integer> {

	@Autowired
	public TipoEquipamentoRest(TipoEquipamentoRepositorio repositorio) {
		super(repositorio);
	}
	
}
