package com.univates.tcc.abacate.integracao.relatorio.impl;

import java.io.File;
import java.io.Serializable;

import org.springframework.stereotype.Component;

import static com.itextpdf.text.Element.ALIGN_LEFT;
import static com.itextpdf.text.Element.ALIGN_TOP;
import static com.itextpdf.text.pdf.ColumnText.showTextAligned;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.integracao.relatorio.GeradorDeRelatorioParaListagem;

@Component
public class GeradorDeRelatoriosParaListagemImpl
	extends RelatorioAbstrato
		implements GeradorDeRelatorioParaListagem {

	@Override
	public <E extends EntidadeAbstrata<ID>, ID extends Serializable> byte[] gerar(Iterable<String> atributosParaListar,
			Iterable<E> entidadesParaImpressao) throws Exception {
		return criarArquivo();
	}
	
	@Override
	void gerarCabecalho(PdfStamper stamper, int pagina, Integer numeroPaginas) throws Exception {
		criarTitulo(pagina, stamper);
		criarLinhaSeparadora(pagina, stamper);
	}

	@Override
	void gerarConteudo(Document documento) throws DocumentException {
		documento.add(new Phrase("Testando conteúdo do relatório"));
	}
	
	private void criarTitulo(Integer pagina, PdfStamper stamper) {
		showTextAligned(stamper.getUnderContent(pagina), ALIGN_LEFT, new Phrase("Teste 1", ConstantesDoRelatorio.ARIAL_8), 20, 820, 0);
		showTextAligned(stamper.getUnderContent(pagina), ALIGN_LEFT, new Phrase("Teste 2", ConstantesDoRelatorio.ARIAL_12), 20, 800, 0);
	}
	
	private void criarLinhaSeparadora(Integer pagina, PdfStamper stamper) {
		Paragraph linha = new Paragraph();
		linha.add(new LineSeparator(0.3f, 2.78f, BaseColor.BLACK, ALIGN_LEFT, 0));

		showTextAligned(stamper.getUnderContent(pagina), ALIGN_LEFT, linha, 20, 790, 0);
	}

}
