package com.univates.tcc.abacate.application.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univates.tcc.abacate.domain.entities.Foo;
import com.univates.tcc.abacate.domain.repositories.FooRepository;

@RestController
@RequestMapping("/foo")
public class FooResource extends AbstractCrudResource<Foo, Long> {

	@Autowired
	public FooResource(FooRepository repository) {
		super(repository);
	}
	
}
