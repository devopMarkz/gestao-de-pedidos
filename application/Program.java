package application;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entities.Cliente;
import model.entities.GestorDePedidos;
import model.entities.Item;
import model.entities.Pedido;
import model.entities.PedidoFisico;
import model.entities.Produto;
import model.entities.enums.StatusPedido;
import model.entities.enums.TipoDoPedido;
import model.services.ProcessaArquivoTxt;

public class Program {

	public static void main(String[] args) {
		
		GestorDePedidos g = new GestorDePedidos(new ProcessaArquivoTxt());
		
		Pedido p = new PedidoFisico(g.getPedidos().size(), LocalDate.now(), new ArrayList<>(), new Cliente("Marcos", "6171717626", "marcos@gmail.com"), StatusPedido.EM_PROCESSAMENTO, TipoDoPedido.FISICO, "Vitor");
		p.adicionarItem(new Item(new Produto("TV"), 2, 2000.0));
		g.adicionarPedido(p);
		
		p = new PedidoFisico(g.getPedidos().size(), LocalDate.now(), new ArrayList<>(), new Cliente("Marcos", "6171717626", "marcos@gmail.com"), StatusPedido.EM_PROCESSAMENTO, TipoDoPedido.FISICO, "Vitor");
		p.adicionarItem(new Item(new Produto("TV"), 2, 2000.0));
		g.adicionarPedido(p);
		
		for (Pedido pedido : g.getPedidos()) {
			g.salvarPedidosEmArquivo("C:\\Users\\Marcos Andre\\Desktop\\javaArqs\\sistema-de-pedidos\\sistema-pedidos\\src\\pedidos", pedido.getNumeroDoPedido());
		}
		
	}

}
