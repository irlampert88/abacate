package com.univates.tcc.abacate.aplicacao.rest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.univates.tcc.abacate.aplicacao.configuracoes.ConstantesDeConfiguracao;
import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.RegistroLog;
import com.univates.tcc.abacate.dominio.repositorios.UsuarioRepositorio;
import com.univates.tcc.abacate.dominio.servicos.PdfServico;

@RestController
@RequestMapping("/pdf")
@CrossOrigin
public class PdfRest {
	
	private PdfServico pdfServico;
	private HttpSession sessao;
	private UsuarioRepositorio repo;

	@Autowired
	public PdfRest(PdfServico pdfServico, HttpSession sessao, UsuarioRepositorio repo) {
		this.pdfServico = pdfServico;
		this.sessao = sessao;
		this.repo = repo;
	}

	@RequestMapping(value = "/fake", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamResource> download() throws Exception {
		sessao.setAttribute(ConstantesDeConfiguracao.Sessao.USUARIO, repo.findAll().get(0));
		
		ObjetoParaImpressao obj = new ObjetoParaImpressao();
		obj.setNomeRelatorio("Lista de Logs do sistema");
		obj.setAtributos(Arrays.asList("id", "dataHora", "tabela", "acao", "usuario.nome", "usuario.email"));
		obj.setTitulos(Arrays.asList("Id", "Data/Hora", "Tabela", "Ação", "Usuário", "E-mail"));
		obj.setAtributoOrdenado("id");
		obj.setOrdem("desc");
		RegistroLog ex = new RegistroLog();
		obj.setEntidadeDeExemplo(ex);
		
		String json = new Gson().toJson(obj);
		System.out.println(json);
		
		String encode = new String(Base64.getEncoder().encode(json.getBytes()));
		System.out.println(encode);
		
		return downloadPdf("RegistroLog", encode);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamResource> downloadPdf(
			@RequestParam(name = "entidade", required = true) String entidade,
			@RequestParam(name = "obj", required = true) String obj) throws Exception {
		
		final File arquivoPdf = pdfServico.gerarArquivoPdf(entidade, obj);
		
		return ResponseEntity
	            .ok()
	            .contentLength(arquivoPdf.length())
	            .contentType(MediaType.parseMediaType("application/pdf"))
	            .body(new InputStreamResource(new FileInputStream(arquivoPdf)));
	}	

}
