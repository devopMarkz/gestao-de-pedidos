package model.entities;

import java.time.LocalDate;
import java.util.List;

import model.entities.enums.StatusPedido;
import model.entities.enums.TipoDoPedido;

public class PedidoFisico extends Pedido {
	
	private String nomeDoVendedor;
	
	// CONSTRUTOR
	
	public PedidoFisico(Integer numeroDoPedido, LocalDate dataPedido, List<Item> itens, Cliente cliente, StatusPedido statusPedido, TipoDoPedido tipoDoPedido, String nomeDoVendedor) {
		super(numeroDoPedido, dataPedido, itens, cliente, statusPedido, tipoDoPedido);
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
		
		System.out.println("Vendedor: " + this.nomeDoVendedor);
		System.out.println("Cliente: " + super.getCliente().obterDetalhesDoCliente());
		System.out.print("Pedido " + super.getNumeroDoPedido() + ": ");
		System.out.println(super.getDataPedido() + " | " + super.getStatusPedido().name());
		System.out.println("Itens: ");
		for (Item item : super.getItens()) {
			System.out.println(item.toString());
		}
		
		System.out.println("Total: R$" + String.format("%.2f", this.calcularValorTotal()));
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder stb = new StringBuilder();
		
		for (Item item : super.getItens()) {
			stb.append(item.toString() + "\n");
		}
		
		return String.format("%d,%s,%s,%s,%s,%s,%s,%s%n%s", super.getNumeroDoPedido(), super.getTipoDoPedido().name(), super.getDataPedido(), super.getCliente().getNome(), super.getCliente().getCpf(), super.getCliente().getEmail(),super.getStatusPedido().name(), this.nomeDoVendedor, stb);
	}

}
