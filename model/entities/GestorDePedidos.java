package model.entities;

import java.util.ArrayList;
import java.util.List;

public class GestorDePedidos {
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	// CONSTRUTORES
	
	public GestorDePedidos() {
		
	}
	
	// GETTERS E SETTERS

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	// MÉTODOS DA CLASSE
	
	public void adicionarPedido(Pedido pedido) {
		this.getPedidos().add(pedido);
	}

}
