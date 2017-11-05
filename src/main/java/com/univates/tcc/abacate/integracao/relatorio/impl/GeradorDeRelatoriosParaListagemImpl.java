package com.univates.tcc.abacate.integracao.relatorio.impl;

import static com.itextpdf.text.Element.ALIGN_LEFT;
import static com.itextpdf.text.Element.ALIGN_TOP;
import static com.itextpdf.text.pdf.ColumnText.showTextAligned;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.univates.tcc.abacate.dominio.entidades.EntidadeAbstrata;
import com.univates.tcc.abacate.integracao.relatorio.GeradorDeRelatorioParaListagem;

@Component
public class GeradorDeRelatoriosParaListagemImpl
	extends RelatorioAbstrato
		implements GeradorDeRelatorioParaListagem {

	private Iterable<String> atributosParaListar;
	private Iterable<? extends EntidadeAbstrata<?>> entidadesParaImpressao;
	private Iterable<String> colunas;

	@Override
	public <E extends EntidadeAbstrata<ID>, ID extends Serializable> byte[] gerar(Iterable<String> atributosParaListar, Iterable<String> colunas,
			Iterable<E> entidadesParaImpressao) throws Exception {
		
		this.atributosParaListar = atributosParaListar;
		this.colunas = colunas;
		this.entidadesParaImpressao = entidadesParaImpressao;
		
		return criarArquivo();
	}
	
	@Override
	void gerarCabecalho(PdfStamper stamper, int pagina, Integer numeroPaginas) throws Exception {
		criarTitulo(pagina, stamper);
		criarLinhaSeparadora(pagina, stamper);
	}

	@Override
	void gerarConteudo(Document documento) throws Exception {
		PdfPTable tabela = new PdfPTable(((Collection)atributosParaListar).size());
		tabela.setKeepTogether(true);
		tabela.setWidthPercentage(100f);

		PdfPCell c = new PdfPCell();
		c.setColspan(((Collection)atributosParaListar).size());
		c.setPaddingTop(0f);
		c.setPaddingBottom(10f);
		c.setHorizontalAlignment(Element.ALIGN_CENTER);
		c.setBorder(Rectangle.NO_BORDER);
		c.addElement(new Phrase("Lista de registros", ConstantesDoRelatorio.ARIAL_12));
		tabela.addCell(c);

		criaCabecalhoDaTabela(tabela);
		
		for (EntidadeAbstrata<?> e: entidadesParaImpressao) {
			for (String atributo : atributosParaListar) {
				tabela.addCell(criaCelulaValor(procuraValorDoAtributo(e, atributo)));
			}
		}

		documento.add(tabela);
	}
	
	private String procuraValorDoAtributo(EntidadeAbstrata<?> e, String atributo) throws Exception {
		String[] partes = atributo.split("\\.");
		String nomeCampo = partes.length == 0 ? atributo : partes[0];
		
		for (Field f : e.getClass().getDeclaredFields()) {
			if (f.getName().equalsIgnoreCase(nomeCampo)) {
				f.setAccessible(true);
				
				Object valorCampo = f.get(e);
				
				return valorTratado(valorCampo, partes);
			}
		}
		
		return e.getClass().getSimpleName() + " não possui " + atributo;
	}

	private String valorTratado(Object valorCampo, String[] partes) throws Exception {
		if (partes.length > 1)
			return procuraValorDoAtributo((EntidadeAbstrata<?>) valorCampo, partes[1]);
		
		if (valorCampo instanceof LocalDateTime)
			return ((LocalDateTime)valorCampo).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		
		return valorCampo == null ? "" : String.valueOf(valorCampo);
	}

	private PdfPCell criaCelulaValor(String valorCelula) {
		Phrase texto = new Phrase(valorCelula, ConstantesDoRelatorio.ARIAL_8);
		PdfPCell celula = new PdfPCell(texto);
		celula.setBorder(Rectangle.NO_BORDER);
		return celula;
	}
	
	private void criaCabecalhoDaTabela(PdfPTable tabela) {
		for (String coluna: colunas) {
			tabela.addCell(criaCelulaDoCabecalho(coluna));
		}
	}
	
	private PdfPCell criaCelulaDoCabecalho(String titulo) {
		Phrase texto = new Phrase(titulo, ConstantesDoRelatorio.ARIAL_8);
		PdfPCell celula = new PdfPCell(texto);
		celula.setBorderWidthTop(0f);
		celula.setBorderWidthRight(0f);
		celula.setBorderWidthLeft(0f);
		celula.setFixedHeight(15f);
		celula.setVerticalAlignment(ALIGN_TOP);
		return celula;
	}
	
	private void criarTitulo(Integer pagina, PdfStamper stamper) {
		showTextAligned(stamper.getUnderContent(pagina), ALIGN_LEFT, new Phrase(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), ConstantesDoRelatorio.ARIAL_8), 20, 820, 0);
		showTextAligned(stamper.getUnderContent(pagina), ALIGN_LEFT, new Phrase("Emitido por Abacate Tech", ConstantesDoRelatorio.ARIAL_12), 20, 800, 0);
	}
	
	private void criarLinhaSeparadora(Integer pagina, PdfStamper stamper) {
		Paragraph linha = new Paragraph();
		linha.add(new LineSeparator(0.3f, 2.78f, BaseColor.BLACK, ALIGN_LEFT, 0));

		showTextAligned(stamper.getUnderContent(pagina), ALIGN_LEFT, linha, 20, 790, 0);
	}

}
