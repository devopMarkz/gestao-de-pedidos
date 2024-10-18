package model.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import model.entities.enums.StatusPedido;
import model.entities.enums.TipoDoPedido;

public abstract class Pedido {
	
	private Integer numeroDoPedido;
	private LocalDate dataPedido;
	private List<Item> itens;
	private Cliente cliente;
	private StatusPedido statusPedido;
	private TipoDoPedido tipoDoPedido;
	
	public Pedido() {
	}
	
	// CONSTRUTOR GERAL PARA RECEBER DE ARQUIVOS O OBJETO
	public Pedido(Integer numeroDoPedido, LocalDate dataPedido, List<Item> itens, Cliente cliente, StatusPedido statusPedido, TipoDoPedido tipoDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
		this.dataPedido = dataPedido;
		this.itens = itens;
		this.cliente = cliente;
		this.statusPedido = statusPedido;
		this.tipoDoPedido = tipoDoPedido;
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
	
	public TipoDoPedido getTipoDoPedido() {
		return this.tipoDoPedido;
	}
	
	public void setTipoDoPedido(TipoDoPedido tipoDoPedido) {
		this.tipoDoPedido = tipoDoPedido;
	}
	
	// MÉTODOS DA CLASSE
	
	public void adicionarItem(Item item) {
		this.getItens().add(item);
	}
	
	public abstract Double calcularValorTotal();
	
	public abstract void gerarRelatorio();

	@Override
	public int hashCode() {
		return Objects.hash(numeroDoPedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(numeroDoPedido, other.numeroDoPedido);
	}
	
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