package model.entities;

import java.time.LocalDate;
import java.util.List;

import model.entities.enums.StatusPedido;

public abstract class Pedido {
	
	private Integer numeroDoPedido;
	private LocalDate dataPedido;
	private List<Item> itens;
	private Cliente cliente;
	private StatusPedido statusPedido;
	
	public Pedido() {
	}
	
	// CONSTRUTOR GERAL PARA RECEBER DE ARQUIVOS O OBJETO
	public Pedido(Integer numeroDoPedido, LocalDate dataPedido, List<Item> itens, Cliente cliente, StatusPedido statusPedido) {
		this.numeroDoPedido = numeroDoPedido;
		this.dataPedido = dataPedido;
		this.itens = itens;
		this.cliente = cliente;
		this.statusPedido = statusPedido;
	}
	
	// GETTERS E SETTERS

	public List<Item> getItens() {
		return itens;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Integer getNumeroDoPedido() {
		return numeroDoPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}
	
	// MÉTODOS DA CLASSE
	
	public void adicionarItem(Item item) {
		this.getItens().add(item);
	}
	
	public abstract Double calcularValorTotal();
	
	public abstract void gerarRelatorio();
	
}

//// CONSTRUTOR PARA PEDIDO EM_PROCESSAMENTO 
//public Pedido(Integer numeroDoPedido, Cliente cliente) {
//	this.numeroDoPedido = numeroDoPedido;
//	this.dataPedido = LocalDate.now();
//	this.cliente = cliente;
//	this.statusPedido = StatusPedido.EM_PROCESSAMENTO;
//}
//
//// CONSTRUTOR PARA PEDIDO ENVIADO
//public Pedido(Integer numeroDoPedido, Cliente cliente, List<Item> itens) {
//	this.numeroDoPedido = numeroDoPedido;
//	this.itens = itens;
//	this.cliente = cliente;
//	this.statusPedido = StatusPedido.ENVIADO;
//}
//