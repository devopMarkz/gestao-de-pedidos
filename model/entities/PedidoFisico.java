package model.entities;

import java.time.LocalDate;
import java.util.List;

import model.entities.enums.StatusPedido;

public class PedidoFisico extends Pedido {
	
	private String nomeDoVendedor;
	
	// CONSTRUTOR
	
	public PedidoFisico(Integer numeroDoPedido, LocalDate dataPedido, List<Item> itens, Cliente cliente, StatusPedido statusPedido, String nomeDoVendedor) {
		super(numeroDoPedido, dataPedido, itens, cliente, statusPedido);
		this.nomeDoVendedor = nomeDoVendedor;
	}

	// GETTERS E SETTERS
	
	public String getNomeDoVendedor() {
		return nomeDoVendedor;
	}

	public void setNomeDoVendedor(String nomeDoVendedor) {
		this.nomeDoVendedor = nomeDoVendedor;
	}

	// MÉTODOS DA CLASSE

	@Override
	public Double calcularValorTotal() {
		double sum = 0;
		
		for (Item item : super.getItens()) {
			sum += item.calcularValorDoItem();
		}
		
		return sum;
	}

	@Override
	public void gerarRelatorio() {
		
		
		
	}
	
	

}
