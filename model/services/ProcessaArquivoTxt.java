package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.entities.GestorDePedidos;
import model.entities.Pedido;

public class ProcessaArquivoTxt implements ProcessadorArquivo {

	@Override
	public List<Pedido> carregarPedidos(String caminhoDoArquivo, GestorDePedidos gestorDePedidos) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvarPedidos(String caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDoArquivo + "//pedido_" + idDoPedido + ".txt"))) {
			
			bw.write(gestorDePedidos.getPedidos().get(idDoPedido).toString());
			
		} catch (IOException e) {
			System.out.println("Erro de escrita do pedido " + idDoPedido);
			e.printStackTrace();
		}
	}

}
