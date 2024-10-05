package model.services;

import java.io.IOException;
import java.util.List;

import model.entities.GestorDePedidos;
import model.entities.Pedido;

public interface ProcessadorArquivo {
	
	List<Pedido> carregarPedidos(String caminhoDoArquivo, GestorDePedidos gestorDePedidos) throws IOException;
	void salvarPedidos(String caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException;

}
