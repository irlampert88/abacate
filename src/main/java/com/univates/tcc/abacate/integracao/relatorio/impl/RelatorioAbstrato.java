package com.univates.tcc.abacate.integracao.relatorio.impl;

import static com.itextpdf.text.Element.ALIGN_RIGHT;
import static com.itextpdf.text.pdf.ColumnText.showTextAligned;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

abstract class RelatorioAbstrato {
	
	abstract void gerarCabecalho(PdfStamper stamper, int pagina, Integer numeroPaginas) throws Exception;
	abstract void gerarConteudo(Document documento) throws DocumentException;

	final byte[] criarArquivo() throws Exception {
		Document document = new Document(PageSize.A4, 20, 20, 80, 40);

		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, buffer);
		
		document.open();
		
		gerarConteudo(document);
		
		document.close();
		
		return generateHeader(buffer.toByteArray());
	}

	private byte[] generateHeader(byte[] bytes) throws Exception {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		PdfReader reader = new PdfReader(bytes);
		PdfStamper stamper = new PdfStamper(reader, buffer);

		Integer numeroPaginas = reader.getNumberOfPages();

		for (int pagina = 1; pagina <= numeroPaginas; pagina++) {
			definePaginator(pagina, numeroPaginas, stamper);
			gerarCabecalho(stamper, pagina, numeroPaginas);
		}
		
		stamper.close();
		return buffer.toByteArray();
	}
	
	private void definePaginator(Integer pagina, Integer numeroPaginas, PdfStamper stamper) {
		final String paginacao = "Página " + pagina + " de " + numeroPaginas;
		showTextAligned(stamper.getUnderContent(pagina), ALIGN_RIGHT, new Phrase(paginacao, ConstantesDoRelatorio.ARIAL_8), 574, 820, 0);
	}
	
}
