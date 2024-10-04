package model.entities;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String email;
	
	// CONSTRUTORES
	
	public Cliente(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}
	
	// GETTERS E SETTERS 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}
	
	// MÉTODOS DA CLASSE
	
	public String obterDetalhesDoCliente() {
		StringBuilder stb = new StringBuilder();
		
		stb.append("Nome: " + this.nome);
		stb.append(" | CPF: " + this.cpf);
		stb.append(" | E-mail: " + this.cpf);
		
		return stb.toString();
	}

}
