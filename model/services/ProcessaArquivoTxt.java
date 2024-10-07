package model.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Cliente;
import model.entities.GestorDePedidos;
import model.entities.Item;
import model.entities.PedidoFisico;
import model.entities.Produto;
import model.entities.enums.StatusPedido;
import model.entities.enums.TipoDoPedido;

public class ProcessaArquivoTxt implements ProcessadorArquivo {

	@Override
	public void carregarPedidos(File caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException {
		List<Item> itens = new ArrayList<>();
		
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader(caminhoDoArquivo + "//pedido_" + idDoPedido + ".txt")))){
			
			String[] fields = sc.nextLine().split(",");
			
			if(fields[1].equalsIgnoreCase(TipoDoPedido.FISICO.name())) {
				Integer numeroDoPedido = Integer.parseInt(fields[0]);
				
				TipoDoPedido tipoDoPedido = TipoDoPedido.valueOf(fields[1]);
				
				LocalDate dataPedido = LocalDate.parse(fields[2]);
				
				Cliente cliente = new Cliente(fields[3], fields[4], fields[5]);
				
				StatusPedido statusPedido = StatusPedido.valueOf(fields[6]);
				
				String nomeDoVendedor = fields[7];
				
				while (sc.hasNextLine()) {
					String[] fieldsItem = sc.nextLine().split(",");
					
					Item item = new Item(new Produto(fieldsItem[0]), Integer.parseInt(fieldsItem[1]), Double.parseDouble(fieldsItem[2]));
					
					itens.add(item);
				}
				
				gestorDePedidos.adicionarPedido(new PedidoFisico(numeroDoPedido, dataPedido, itens, cliente, statusPedido, tipoDoPedido, nomeDoVendedor));
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao carregar o pedido " + idDoPedido);
			e.printStackTrace();
		}

	}

	@Override
	public void salvarPedidos(File caminhoDoArquivo, Integer idDoPedido, GestorDePedidos gestorDePedidos) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoDoArquivo + "//pedido_" + idDoPedido + ".txt"))) {
			
			if(gestorDePedidos.getPedidos().get(idDoPedido) instanceof PedidoFisico) {
				PedidoFisico pf = (PedidoFisico) gestorDePedidos.getPedidos().get(idDoPedido);
				bw.write(pf.toString());
			}
			
		} catch (IOException e) {
			System.out.println("Erro de escrita do pedido " + idDoPedido);
			e.printStackTrace();
		}
	}

}
