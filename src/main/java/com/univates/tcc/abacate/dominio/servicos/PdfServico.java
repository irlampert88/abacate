package com.univates.tcc.abacate.dominio.servicos;

import java.io.File;

public interface PdfServico {

	public File gerarArquivoPdf(String classe, String ojbEmBase64) throws Exception;
}
