package utils;
import java.util.LinkedList;

import main.Conta;

public class Extrato {
	private String mes;
	private Conta conta;
	private LinkedList<Transacao> historico;
	public Extrato() {
		historico = new LinkedList<>();
	}
	
	public void addTransacao(Conta conta, String mes, String dia, String hist, String valor) {
		this.mes=mes;
		this.conta = conta;
		historico.add(new Transacao(dia, hist, valor));
	}
	public void imprimirExtrato() {
		System.out.printf("Mês de referência: %s\n", this.mes);
		System.out.println("Dados da Conta");
		System.out.println(String.format("Titular: %s", this.conta.getTitular()));
		System.out.println(String.format("Agencia: %d", this.conta.getAgencia()));
		System.out.println(String.format("Numero: %d", this.conta.getNumero()));
		for(Transacao t: historico) {
			System.out.printf("%s", t);
		}
		System.out.println("Saldo: "+this.conta.getSaldo());
	}
}
