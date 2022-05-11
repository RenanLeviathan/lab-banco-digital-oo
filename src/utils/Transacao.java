package utils;

public class Transacao {
	private String dia;
	private String hist;
	private String valor;
	
	public Transacao(String dia, String hist, String valor) {
		this.dia = dia;
		this.hist = hist;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return this.dia+" "+this.hist+"---------------- R$ "+this.valor+"\n";
	}
}
