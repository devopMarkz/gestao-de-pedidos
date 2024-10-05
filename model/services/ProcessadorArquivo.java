package model.services;

import java.io.IOException;

import model.entities.GestorDePedidos;

public interface ProcessadorArquivo {
	
	void carregarPedidos(String caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException;
	void salvarPedidos(String caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException;

}
