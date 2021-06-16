

package refatoracaoLoja;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		boolean clienteVIP = false;
		Produto p1 = new Produto("Arroz", 5, 18.75);
		Produto p2 = new Produto("Feijão", 1, 4.95);
		Produto p3 = new Produto("Leite", 1, 3.49);
		ArrayList<Produto> produtos = new ArrayList();
		produtos.add(p1);
		produtos.add(p2);
		produtos.add(p3);

		// Calcula o somatório dos preços:
		double total = CalculaSomatorioPreco(clienteVIP, produtos);
		// Adiciona taxa de entrega:
		AdicionaTaxaEntrega(total);
	}

	private static void AdicionaTaxaEntrega(double total) {
		DayOfWeek diaSemana = LocalDate.now().getDayOfWeek();
		if (diaSemana == DayOfWeek.SUNDAY) {
			total += 10.00;
		} else {
			total += 5.00;
		}
		System.out.println(total);
	}

	private static double CalculaSomatorioPreco(boolean clienteVIP, ArrayList<Produto> produtos) {
		double total = 0.0;
		for (Produto produto : produtos) {
			total += produto.getPreco() * produto.getQuantidade();
		}
		// Aplica desconto:
		if (clienteVIP) {
			total *= 0.90;
		} else {
			total *= 0.95;
		}
		return total;
	}
}