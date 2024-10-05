package model.services;

import java.io.IOException;
import java.util.List;

import model.entities.Pedido;

public interface ProcessadorArquivo {
	
	List<Pedido> carregarPedidos(String caminhoDoArquivo) throws IOException;
	void salvarPedidos(String caminhoDoArquivo, List<Pedido> pedidos) throws IOException;

}
