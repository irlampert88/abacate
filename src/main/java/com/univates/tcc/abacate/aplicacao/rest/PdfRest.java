package com.univates.tcc.abacate.aplicacao.rest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.RegistroLogServico;
import com.univates.tcc.abacate.dominio.utilitarios.ProcuradorDeClasse;
import com.univates.tcc.abacate.integracao.apis.EntidadeAbstrataDeserializer;

@RestController
@RequestMapping("/pdf")
@CrossOrigin
public class PdfRest {
	
	
	private ImpressaoDeEntidades impressaoDeEntidades;
	private RegistroLogServico servicoDeCrud;

	@Autowired
	public PdfRest(ImpressaoDeEntidades impressaoDeEntidades, RegistroLogServico servicoDeCrud) {
		this.impressaoDeEntidades = impressaoDeEntidades;
		this.servicoDeCrud = servicoDeCrud;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamResource> downloadPdf(
			@RequestParam(name = "entidade", required = true) String entidade,
			@RequestParam(name = "obj", required = true) String obj) throws Exception {
		
		Class classeDaEntidade = ProcuradorDeClasse.classeDaEntidadePeloNome(entidade);
		
		String jsonDoObjeto = new String(Base64.getDecoder().decode(obj));
		
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(EntidadeAbstrata.class, new EntidadeAbstrataDeserializer(classeDaEntidade.getCanonicalName()))
				.create();
		
		ObjetoParaImpressao paraImpressao = gson.fromJson(jsonDoObjeto, ObjetoParaImpressao.class);
		
		final byte[] arquivo = impressaoDeEntidades.gerarListaParaImpressao(paraImpressao, null, null, null, null, servicoDeCrud);
		File arquivoPdf = File.createTempFile("Abacate", String.valueOf(System.currentTimeMillis()));
		Files.write(arquivo, arquivoPdf);
		
		return ResponseEntity
	            .ok()
	            .contentLength(arquivoPdf.length())
	            .contentType(
	                    MediaType.parseMediaType("application/pdf"))
	            .body(new InputStreamResource(new FileInputStream(arquivoPdf)));
	}	

}
