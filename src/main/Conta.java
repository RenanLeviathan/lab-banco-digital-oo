package main;

import java.util.GregorianCalendar;

import utils.Extrato;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	private Extrato extrato;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.extrato = new Extrato();
	}

	@Override
	public void sacar(double valor) {
		if(valor <= this.saldo) {
			saldo -= valor;
			this.extrato.addTransacao(
					this, 
					Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.MONTH)+1), 
					Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH)), 
					"Retirada de valores", 
					"-"+Double.toString(valor));
		}else {
			System.out.println("Saldo Insuficiente na sua conta");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		this.extrato.addTransacao(
				this, 
				Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.MONTH)+1), 
				Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH)), 
				"Depósito", 
				Double.toString(valor));
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
		this.extrato.addTransacao(
				this, 
				Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.MONTH)+1), 
				Integer.toString(GregorianCalendar.getInstance().get(GregorianCalendar.DAY_OF_MONTH)), 
				"Transferência de R$ "+valor+" para "+((Conta) contaDestino).getTitular(), 
				"-"+Double.toString(valor));
	}

	public int getAgencia() {
		return agencia;
	}
	
	public String getTitular() {
		return this.cliente.getNome();
	}
	
	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void consultarExtrato() {
		this.extrato.imprimirExtrato();
	}
/*
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}*/
}
