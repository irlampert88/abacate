package com.univates.tcc.abacate.aplicacao.rest;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;
import com.univates.tcc.abacate.dominio.entidades.RegistroLog;
import com.univates.tcc.abacate.dominio.servicos.ImpressaoDeEntidades;
import com.univates.tcc.abacate.dominio.servicos.RegistroLogServico;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AbacateRest {
	
	private ImpressaoDeEntidades impressaoDeEntidades;
	private RegistroLogServico servicoDeCrud;

	@Autowired
	public AbacateRest(ImpressaoDeEntidades impressaoDeEntidades, RegistroLogServico servicoDeCrud) {
		this.impressaoDeEntidades = impressaoDeEntidades;
		this.servicoDeCrud = servicoDeCrud;
	}
	
	public static void main(String[] args) {
		ObjetoParaImpressao objetoParaImpressao = new ObjetoParaImpressao();
		RegistroLog exemplo = new RegistroLog();
		exemplo.setTabela("marcas");
		objetoParaImpressao.setEntidadeDeExemplo(exemplo);
		objetoParaImpressao.setTitulos(Arrays.asList("Id", "Tabela", "Ação", "Usuário", "Data e Hora"));
		objetoParaImpressao.setAtributos(Arrays.asList("id", "tabela", "acao", "usuario.nome", "dataHora"));
		
		System.out.println(new Gson().toJson(objetoParaImpressao));
	}

	@RequestMapping(value="/pdf", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<InputStreamResource> downloadPdf() throws Exception {
		
		ObjetoParaImpressao objetoParaImpressao = new ObjetoParaImpressao();
		RegistroLog exemplo = new RegistroLog();
		exemplo.setTabela("marcas");
		objetoParaImpressao.setEntidadeDeExemplo(exemplo);
		objetoParaImpressao.setTitulos(Arrays.asList("Id", "Tabela", "Ação", "Usuário", "Data e Hora"));
		objetoParaImpressao.setAtributos(Arrays.asList("id", "tabela", "acao", "usuario.nome", "dataHora"));
		
		final byte[] arquivo = impressaoDeEntidades.gerarListaParaImpressao(objetoParaImpressao, null, null, null, null, servicoDeCrud);
		File arquivoPdf = File.createTempFile("Abacate", String.valueOf(System.currentTimeMillis()));
		Files.write(arquivo, arquivoPdf);
		
		return ResponseEntity
	            .ok()
	            .contentLength(arquivoPdf.length())
	            .contentType(
	                    MediaType.parseMediaType("application/pdf"))
	            .body(new InputStreamResource(new FileInputStream(arquivoPdf)));
		
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "{\"entidadeDeExemplo\":{\"tabela\":\"marcas\"},\"titulos\":[\"Id\",\"Tabela\",\"Ação\",\"Usuário\",\"Data e Hora\"],\"atributos\":[\"id\",\"tabela\",\"acao\",\"usuario.nome\",\"dataHora\"]}\r\n" + 
				"";
//		return "Bem vindo ao Abacate V1.0.0 ! [ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS")) + " ]";
	}

}
