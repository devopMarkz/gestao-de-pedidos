package model.entities;

public class Item {
	
	private Produto produto;
	private Integer quantidade;
	private Double precoUnitario;
	
	// CONSTRUTORES
	
	public Item() {
	}
	
	public Item(Produto produto, Integer quantidade, Double precoUnitario) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}
	
	// GETTERS E SETTERS

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	// MÉTODOS DA CLASSE
	
	public Double calcularValorDoItem() {
		return this.quantidade * this.precoUnitario;
	}

}
