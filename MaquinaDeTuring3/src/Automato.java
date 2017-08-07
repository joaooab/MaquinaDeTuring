import java.util.ArrayList;
import java.util.List;

public class Automato {

	private String alfabeto;
	private String estados;
	private String estadosFinais;
	private String estadoInicial;
	public List<FuncaoTransicao> lista;
	private String estadoFinal;

	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) {
		this.alfabeto = alfabeto;
	}

	public String getEstados() {
		return estados;
	}

	public void setEstados(String estados) {
		this.estados = estados;
	}

	public String getEstadosFinais() {
		return estadosFinais;
	}

	public void setEstadosFinais(String estadosFinais) {
		this.estadosFinais = estadosFinais;
	}

	public String getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public String getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(String estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public List<FuncaoTransicao> getLista() {
		if (lista == null) {
			lista = new ArrayList<FuncaoTransicao>();
		}
		return lista;
	}

	public void setLista(List<FuncaoTransicao> lista) {
		this.lista = lista;
	}

	// VERIFICADORES
	public boolean verificarDuplicidade(char[] vetor) {
		for (int i = 0; i < vetor.length - 1; i++) {
			for (int j = i + 1; j < vetor.length; j++) {
				if (vetor[i] == vetor[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean verificarEstados(char[] vetor) {// Verifica se exite o estodo
													// no automato
		char[] aux = estados.toCharArray();
		boolean saida = true;
		for (int i = 0; i < vetor.length; i++) {
			saida = false;
			for (int j = 0; j < aux.length; j++) {
				if (vetor[i] == aux[j]) {
					saida = true;
					break;
				}
			}
			if (!saida) {
				return saida;
			}
		}
		return saida;
	}

	public boolean pertenceAlfabeto(char[] vetor) { // Verifica se os símbolos
													// da cadeia pertence ao
													// Alfabeto

		char[] aux = alfabeto.toCharArray();
		boolean saida = true;
		for (int i = 0; i < vetor.length; i++) {
			saida = false;
			for (int j = 0; j < aux.length; j++) {
				if (vetor[i] == aux[j]) {
					saida = true;
					break;
				}
			}
			if (!saida)
				return saida;
		}
		return saida;
	}

	// FUNCOES

	public FuncaoTransicao buscaFuncao(String estadoAtual, String simboloAtual) {

		FuncaoTransicao funcao = new FuncaoTransicao();
		for (int i = 0; i < lista.size(); i++) {
			if (this.lista.get(i).getEstadoAtual().equals(estadoAtual)
					&& this.lista.get(i).getSimboloAtual().equals(simboloAtual)) {
				funcao = lista.get(i);
				break;
			}
		}
		return funcao;
	}

	public boolean verificarCadeia(char[] cadeia) {

		FuncaoTransicao funcao = new FuncaoTransicao();
		funcao = lista.get(0);

		for (int i = 0; i < cadeia.length; i++) {
			cadeia[i] = funcao.getSimboloGravado().charAt(0);

			if (funcao.getDirecao().equals(tipoMovimento.ESQUERDA)) {
				i = i - 2;
			} else if (funcao.getDirecao().equals(tipoMovimento.NDA)) {
				i = i - 1;
			}
			
			if (i + 1 < cadeia.length) {
				char aux = cadeia[i + 1];
				funcao = buscaFuncao(funcao.getEstadoNovo(), String.valueOf(aux));
				if (funcao.getEstadoAtual() == null) {
					return false;
				}
			}
		}

		if (funcao.getEstadoNovo().equals(getEstadoFinal())) {
			return true;
		} else {
			return false;
		}
	}
}