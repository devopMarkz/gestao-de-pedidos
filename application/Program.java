package application;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entities.Cliente;
import model.entities.Item;
import model.entities.PedidoFisico;
import model.entities.Produto;
import model.entities.enums.StatusPedido;
import model.entities.enums.TipoDoPedido;

public class Program {

	public static void main(String[] args) {
		
		PedidoFisico p = new PedidoFisico(1, LocalDate.now(), new ArrayList<>(), new Cliente("Marcos", "6171717626", "marcos@gmail.com"), StatusPedido.EM_PROCESSAMENTO, TipoDoPedido.FISICO, "Vitor");
		
		p.adicionarItem(new Item(new Produto("TV"), 2, 1000.0));
		p.adicionarItem(new Item(new Produto("Geladeira"), 1, 1500.0));
		p.adicionarItem(new Item(new Produto("Balcão"), 1, 800.0));
		
		p.gerarRelatorio();
		
	}

}
