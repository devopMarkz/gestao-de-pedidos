package model.services;

import java.io.File;

public class CaminhoDeArquivoTxt implements CaminhoDeArquivo {

	@Override
	public File getPathPedidos() {
		return new File("C:\\Users\\marcos.andre\\Desktop\\Suprimentos CPL\\arquivos java\\Interfaces\\sistema-de-pedidos\\pedidos\\src\\pedidos");
	}

}
