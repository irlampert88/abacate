package com.univates.tcc.abacate.aplicacao.rest;

import static com.univates.tcc.abacate.dominio.utilitarios.IdentificadorDeGenerics.PRIMEIRO_GENERIC;
import static com.univates.tcc.abacate.dominio.utilitarios.IdentificadorDeGenerics.identificaClasseDeUmGeneric;
import static com.univates.tcc.abacate.dominio.utilitarios.InstanciadorDeObjetos.criaInstancia;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.univates.tcc.abacate.aplicacao.rest.autorizacao.RequerAutenticacao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.RequerPermissao;
import com.univates.tcc.abacate.aplicacao.rest.permissao.TipoDePermissao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.ServicoDeCrud;
import com.univates.tcc.abacate.dominio.utilitarios.LimparAtributoDoObjeto;

@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@SuppressWarnings("all")
abstract class CrudAbstratoRest<ENTIDADE extends EntidadeAbstrata<ID>, ID extends Serializable> {

	private final ServicoDeCrud<ENTIDADE, ID> servicoDeCrud;
	
	public CrudAbstratoRest(ServicoDeCrud<ENTIDADE, ID> servicoDeCrud) {
		this.servicoDeCrud = servicoDeCrud;
	}
	
	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.INSERIR)
	@RequestMapping(method=RequestMethod.POST) 
	public final ResponseEntity<ENTIDADE> save(@RequestBody ENTIDADE entity){
		entity = servicoDeCrud.inserir(entity);		
		return new ResponseEntity<ENTIDADE>(entity, HttpStatus.OK);
	}	
	
	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.ALTERAR)
	@RequestMapping(method=RequestMethod.PATCH)
	public final ResponseEntity<ENTIDADE> update(@RequestBody ENTIDADE entity){
		entity = servicoDeCrud.alterar(entity);
		return new ResponseEntity<ENTIDADE>(entity, HttpStatus.OK);
	}	

	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.DELETAR)
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public final ResponseEntity<ID> delete(@PathVariable("id") ID id){
		servicoDeCrud.deletar(id);
		return new ResponseEntity<ID>(id, HttpStatus.OK);
	}
	
	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.CONSULTAR)
	@RequestMapping(method=RequestMethod.GET, value = "/{id}")
	public final ResponseEntity<ENTIDADE> findById(@PathVariable ID id){
		final ENTIDADE found = servicoDeCrud.buscarPorId(id);
		return new ResponseEntity<ENTIDADE>(found, HttpStatus.OK);
	}
	
	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.CONSULTAR)
	@RequestMapping(method=RequestMethod.GET)
	public final ResponseEntity<Iterable<ENTIDADE>> findAll(
			@RequestParam(name = "pagina", required = false) Integer pagina, 
			@RequestParam(name = "quantidade", required = false) Integer quantidade, 
			@RequestParam(name = "atributoOrdenado", required = false) String atributoOrdenado, 
			@RequestParam(name = "ordem", required = false, defaultValue = "asc") String ordem){
		final Iterable<ENTIDADE> entidadesEncontradas = servicoDeCrud.buscarTodosComPaginacao(pagina, quantidade, atributoOrdenado, ordem);
		new LimparAtributoDoObjeto().removerArquivosDaEntidade(entidadesEncontradas);
		return new ResponseEntity<Iterable<ENTIDADE>>(entidadesEncontradas, HttpStatus.OK);		
	}

	@RequerAutenticacao
	@RequerPermissao(tipoDePermissao = TipoDePermissao.CONSULTAR)
	@RequestMapping(value = "/pesquisar", method=RequestMethod.POST)
	public final ResponseEntity<Iterable<ENTIDADE>> pesquisarPeloExemplo(@
			RequestBody ENTIDADE entity, 
			@RequestParam(name = "pagina", required = true) Integer pagina, 
			@RequestParam(name = "quantidade", required = true) Integer quantidade, 
			@RequestParam(name = "atributoOrdenado", required = false) String atributoOrdenado, 
			@RequestParam(name = "ordem", required = false, defaultValue = "asc") String ordem){
		final Collection<ENTIDADE> entidadesEncontradas = servicoDeCrud.buscarPeloExemploComPaginacao(entity, pagina, quantidade, atributoOrdenado, ordem);
		new LimparAtributoDoObjeto().removerArquivosDaEntidade(entidadesEncontradas);
		return new ResponseEntity<Iterable<ENTIDADE>>(entidadesEncontradas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/estrutura", method=RequestMethod.GET)
	public final ResponseEntity<ENTIDADE> exibirEstrutura(){
		final Class<?> classeDaEntidade = identificaClasseDeUmGeneric(getClass(), PRIMEIRO_GENERIC);
		final ENTIDADE instanciaVaziaDaEntidade = (ENTIDADE) criaInstancia(classeDaEntidade);
		return new ResponseEntity<ENTIDADE>(instanciaVaziaDaEntidade, HttpStatus.OK);
	}
	
}
