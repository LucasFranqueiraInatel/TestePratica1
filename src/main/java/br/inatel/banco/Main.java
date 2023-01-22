package br.inatel.banco;

import br.inatel.banco.services.ContaCorrenteService;
import br.inatel.banco.services.ContaPoupancaService;

public class Main {

    public static void main(String[] args) {
        System.out.println("-----------------------Inatel Bank-----------------------");

        ContaCorrenteService contaCorrente = new ContaCorrenteService("1111", "1234567-9");
        ContaPoupancaService contaPoupanca = new ContaPoupancaService("2222", "9876543-1");




        contaCorrente.pagarConta(70.56, "CEMIG");
        contaCorrente.depositoConta(300, "PIX");
        System.out.println("Saldo: " + contaCorrente.consultaSaldo());
        contaCorrente.adicionarCredito(3000);
        System.out.println("Credito: " + contaCorrente.consultaCredito());
        contaCorrente.pagarConta(70.56, "CEMIG");
        System.out.println("Saldo: " + contaCorrente.consultaSaldo());
        contaCorrente.pagarCredito(100);
        System.out.println("Credito: " + contaCorrente.consultaCredito());
        System.out.println("------------Conta Corrente-----------");
        contaCorrente.consultaExtrato();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("------------Conta Poupança------------");
        contaPoupanca.depositoConta(5600, "PIX");
        System.out.println("Saldo: " + contaPoupanca.consultaSaldo());
        contaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + contaPoupanca.consultaRendimento());
        contaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + contaPoupanca.consultaRendimento());
        contaPoupanca.pagarConta(99.90, "Internet");
        System.out.println("Saldo: " + contaPoupanca.consultaSaldo());
        contaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + contaPoupanca.consultaRendimento());
        contaPoupanca.consultaExtrato();

    }
}
