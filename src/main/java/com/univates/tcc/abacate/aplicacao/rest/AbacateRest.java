package com.univates.tcc.abacate.aplicacao.rest;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.io.Files;
import com.univates.tcc.abacate.dominio.agregadores.ObjetoParaImpressao;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AbacateRest {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "Bem vindo ao Abacate V1.0.0 ! [ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS")) + " ]";
	}

	@RequestMapping(value = "/pdf", method = RequestMethod.GET, produces = "application/pdf")
	public ResponseEntity<InputStreamResource> downloadPDFFile()
	        throws Exception {

//		final byte[] arquivo = impressaoDeEntidades.gerarListaParaImpressao(new ObjetoParaImpressao(), null, null, null, null, servicoDeCrud);
//
		File file = File.createTempFile("impressao", "HOJE");
//		Files.write(arquivo, file);
		
//	    ClassPathResource pdfFile = new ClassPathResource("pdf-sample.pdf");

	    return ResponseEntity
	            .ok()
	            .contentLength(file.length())
	            .contentType(
	                    MediaType.parseMediaType("application/pdf"))
	            .body(new InputStreamResource(new FileInputStream(file)));
	}
	
//	@RequestMapping(value = "/TESTE", method=RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	public final ResponseEntity<File> teste(){ 
//		try {
//			final byte[] arquivo = impressaoDeEntidades.gerarListaParaImpressao(new ObjetoParaImpressao(), null, null, null, null, servicoDeCrud);
//
//			File file = File.createTempFile("impressao", "HOJE");
////			Path path = Paths.get(file.getAbsolutePath() + (file.getAbsolutePath().endsWith(".pdf") ? "" : ".pdf"));
//			Files.write(arquivo, file);
//			
//			return new ResponseEntity<File>(file, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
}
