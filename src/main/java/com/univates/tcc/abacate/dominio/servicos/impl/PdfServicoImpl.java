package com.univates.tcc.abacate.dominio.servicos.impl;

import java.io.File;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.univates.tcc.abacate.aplicacao.rest.permissao.TipoDePermissao;
import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.entidades.Usuario;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.PdfServico;
import com.univates.tcc.abacate.dominio.servicos.RegistroLogServico;
import com.univates.tcc.abacate.dominio.servicos.UsuarioServico;
import com.univates.tcc.abacate.dominio.utilitarios.ProcuradorDeClasse;
import com.univates.tcc.abacate.integracao.apis.EntidadeAbstrataDeserializer;

@Service
public class PdfServicoImpl 
	implements PdfServico {
	
	private ImpressaoDeEntidades impressaoDeEntidades;
	private RegistroLogServico servicoDeCrud;
	private UsuarioServico usuarioServico;

	@Autowired
	public PdfServicoImpl(ImpressaoDeEntidades impressaoDeEntidades, RegistroLogServico servicoDeCrud, UsuarioServico usuarioServico) {
		this.impressaoDeEntidades = impressaoDeEntidades;
		this.servicoDeCrud = servicoDeCrud;
		this.usuarioServico = usuarioServico;
	}
	
	@Override
	public File gerarArquivoPdf(String classe, String ojbEmBase64) throws Exception {
		Class classeDaEntidade = ProcuradorDeClasse.classeDaEntidadePeloNome(classe);
		
		String jsonDoObjeto = new String(Base64.getDecoder().decode(ojbEmBase64), "iso-8859-1");
		
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(EntidadeAbstrata.class, new EntidadeAbstrataDeserializer(classeDaEntidade.getCanonicalName()))
				.create();
		
		ObjetoParaImpressao paraImpressao = gson.fromJson(jsonDoObjeto, ObjetoParaImpressao.class);

		validarPermissaoDoUsuarioLogado(classeDaEntidade, paraImpressao.getAuthorization());
		
		File arquivoPdf = impressaoDeEntidades.gerarListaParaImpressao(paraImpressao, paraImpressao.getNomeRelatorio(), paraImpressao.getPagina(), 
				paraImpressao.getQuantidade(), paraImpressao.getAtributoOrdenado(), paraImpressao.getOrdem(), servicoDeCrud);
		
		return arquivoPdf;
	}

	private void validarPermissaoDoUsuarioLogado(Class classeDaEntidade, String authorization) {
		Usuario usuarioLogado = usuarioServico.autenticarToken(authorization);
		usuarioServico.validarSeUsuarioPossuiPermissao(usuarioLogado, TipoDePermissao.CONSULTAR, classeDaEntidade);
	}

}
