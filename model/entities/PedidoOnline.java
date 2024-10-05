package model.entities;

import java.time.LocalDate;
import java.util.List;

import model.entities.enums.StatusPedido;
import model.entities.enums.TipoDoPedido;

public class PedidoOnline extends Pedido {
	
	private String enderecoDeEntrega;
	private Double taxaDeEntrega;
	
	// CONSTRUTORES
	
	public PedidoOnline() {
		super();
	}
	
	public PedidoOnline(Integer numeroDoPedido, LocalDate dataPedido, List<Item> itens, Cliente cliente, StatusPedido statusPedido, TipoDoPedido tipoDoPedido, String enderecoDeEntrega, Double taxaDeEntrega) {
		super(numeroDoPedido, dataPedido, itens, cliente, statusPedido, tipoDoPedido);
		this.enderecoDeEntrega = enderecoDeEntrega;
		this.taxaDeEntrega = taxaDeEntrega;
	}
	
	// GETTERS E SETTERS

	public String getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(String enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}

	public Double getTaxaDeEntrega() {
		return taxaDeEntrega;
	}

	public void setTaxaDeEntrega(Double taxaDeEntrega) {
		this.taxaDeEntrega = taxaDeEntrega;
	}

	@Override
	public Double calcularValorTotal() {
		double sum = 0;
		
		for (Item item : super.getItens()) {
			sum += item.calcularValorDoItem();
		}
		
		return sum + this.taxaDeEntrega;
	}

	@Override
	public void gerarRelatorio() {

		System.out.println("Endereço/Entrega: " + this.enderecoDeEntrega + " - Taxa de Entrega: R$" + String.format("%.2f", this.taxaDeEntrega));
		System.out.println("Cliente: " + super.getCliente().obterDetalhesDoCliente());
		System.out.print("Pedido " + super.getNumeroDoPedido() + ": ");
		System.out.println(super.getDataPedido() + " | " + super.getStatusPedido().name());
		System.out.println("Itens: ");
		for (Item item : super.getItens()) {
			System.out.println(item.toString());
		}
		
		System.out.println("Total: R$" + String.format("%.2f", this.calcularValorTotal()));
		
	}
	
	

}
