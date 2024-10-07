package model.services;

import java.io.File;
import java.io.IOException;

import model.entities.GestorDePedidos;

public interface ProcessadorArquivo {
	
	void carregarPedidos(File caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException;
	void salvarPedidos(File caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException;

}
