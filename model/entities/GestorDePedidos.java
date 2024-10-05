package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.services.ProcessadorArquivo;

public class GestorDePedidos {
	
	private List<Pedido> pedidos = new ArrayList<>();
	private ProcessadorArquivo processadorArquivo;
	
	// CONSTRUTORES
	
	public GestorDePedidos(ProcessadorArquivo processadorArquivo) {
		this.processadorArquivo = processadorArquivo;
	}
	
	// GETTERS E SETTERS

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public ProcessadorArquivo getProcessadorArquivo() {
		return processadorArquivo;
	}

	public void setArquivoProcessavel(ProcessadorArquivo processadorArquivo) {
		this.processadorArquivo = processadorArquivo;
	}
	
	// MÉTODOS DA CLASSE

	public void adicionarPedido(Pedido pedido) {
		this.getPedidos().add(pedido);
	}
	
	public void salvarPedidosEmArquivo() {
		
	}

}
