import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorAutomato {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileReader("automato.txt"));
		Automato automato = new Automato();
		boolean verificador;
		boolean verificadorAux;

		// PRIMEIRA LINHA
		String[] aux = sc.next().split(";");
		String[] aux2 = aux[0].split(",");
		String[] aux3 = aux[1].split(","); 

		String estados = "";
		String alfabeto = "";

		for (int i = 0; i < aux2.length; i++) {
			estados += aux2[i];
		}
		for (int i = 0; i < aux3.length; i++) {
			alfabeto += aux3[i];
		}
		verificador = automato.verificarDuplicidade(alfabeto.toCharArray());
		if(!verificador){
			System.out.println("Alfabeto inválido");
			return;
		}
		
		automato.setAlfabeto(alfabeto);
		automato.setEstados(estados);

		// SEGUNDA LINHA
		String cadeia;
		cadeia = sc.next();
		cadeia += "_";
		
		// ESTADO FINAL
		char[] auxFinal = estados.toCharArray();
		String estadoFinal = String.valueOf(auxFinal[auxFinal.length-2]);
		estadoFinal += String.valueOf(auxFinal[auxFinal.length-1]);
		automato.setEstadoFinal(estadoFinal);

		// FUNCOES
		automato.getLista();
		while (sc.hasNext()) {
			String funcoes[] = sc.next().split(",");

			String estadoAtual = funcoes[0];
			String simboloAtual = funcoes[1];
			String estadoNovo = funcoes[3];
			String simboloGravado = funcoes[4];
			String direcao = funcoes[5];

			FuncaoTransicao funcao;

			if (direcao.equals("d") || direcao.equals("D")) {
				funcao = new FuncaoTransicao(estadoAtual, simboloAtual, simboloGravado, tipoMovimento.DIREITA,
						estadoNovo);
			} else if (direcao.equals("e") || direcao.equals("E")) {
				funcao = new FuncaoTransicao(estadoAtual, simboloAtual, simboloGravado, tipoMovimento.ESQUERDA,
						estadoNovo);
			} else {
				funcao = new FuncaoTransicao(estadoAtual, simboloAtual, simboloGravado, tipoMovimento.NDA, estadoNovo);
			}

			automato.lista.add(funcao);
		}

		// IMPIRMIR FUNCOES
		System.out.println("Tabela transicao: ");
		System.out.print("({" + estados + "})");
		System.out.println("({" + alfabeto + "})");
		System.out.println("(" + cadeia + ")");

		for (int i = 0; i < automato.getLista().size(); i++) {
			FuncaoTransicao funcao = automato.getLista().get(i);
			System.out.print(funcao.getEstadoAtual());
			System.out.print(" " + funcao.getSimboloAtual());
			System.out.print(" => " + funcao.getEstadoNovo());
			System.out.print(" " + funcao.getSimboloGravado());
			System.out.println(" " + funcao.getDirecao());
		}
		System.out.println();
		
		verificador = automato.verificarCadeia(cadeia.toCharArray());
		
		if (verificador) {
			System.out.println("Cadeia válida!");
		} else {
			System.out.println("Cadeia inválida!");
		}
	}
}