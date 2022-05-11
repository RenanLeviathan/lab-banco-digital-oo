package main;
import utils.Splash;

public class Main {

	public static void main(String[] args) {
		//Telinha de splash
		new Splash();
		Cliente renan = new Cliente();
		renan.setNome("Renan");
		Conta cc = new ContaCorrente(renan);
		Conta poupanca = new ContaPoupanca(renan);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.consultarExtrato();
		poupanca.consultarExtrato();
		/*cc.imprimirExtrato();
		poupanca.imprimirExtrato();*/
	}

}
