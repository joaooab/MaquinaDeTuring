
public class FuncaoTransicao {

	private String estadoAtual;
	private String simboloAtual;
	private String simboloGravado;
	private tipoMovimento direcao;
	private String estadoNovo;
	
	public FuncaoTransicao(String estadoAtual, String simboloAtual, String simboloGravado, tipoMovimento direcao,
			String estadoNovo) {
		this.estadoAtual = estadoAtual;
		this.simboloAtual = simboloAtual;
		this.simboloGravado = simboloGravado;
		this.direcao = direcao;
		this.estadoNovo = estadoNovo;
	}
	
	public FuncaoTransicao(){
		
	}

	public String getEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(String estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public String getSimboloAtual() {
		return simboloAtual;
	}

	public void setSimboloAtual(String simboloAtual) {
		this.simboloAtual = simboloAtual;
	}

	public String getSimboloGravado() {
		return simboloGravado;
	}

	public void setSimboloGravado(String simboloGravado) {
		this.simboloGravado = simboloGravado;
	}

	public tipoMovimento getDirecao() {
		return direcao;
	}

	public void setDirecao(tipoMovimento direcao) {
		this.direcao = direcao;
	}

	public String getEstadoNovo() {
		return estadoNovo;
	}

	public void setEstadoNovo(String estadoNovo) {
		this.estadoNovo = estadoNovo;
	}

}
