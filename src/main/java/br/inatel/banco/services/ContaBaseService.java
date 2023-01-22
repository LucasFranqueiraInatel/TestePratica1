package br.inatel.banco.services;

import br.inatel.banco.interfaces.IContaService;

import java.util.ArrayList;

public abstract class ContaBaseService implements IContaService
{
    private String agencia;
    private String numeroConta;
    private double saldo;
    private ArrayList<Pagamentos> extrato = new ArrayList<Pagamentos>();

    public ContaBaseService(String agencia, String numeroConta) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
    }

    @Override
    public boolean pagarConta(double valor, String nome) {
        if (this.saldo < valor || this.saldo < 0) {
            System.out.println("Nao foi possivel realizar o pagamento");
            return false;
        }

        this.saldo = saldo - valor;

        extrato.add(new Pagamentos(-valor, nome, "Pagamento"));

        return true;

    }

    @Override
    public boolean depositoConta(double valor, String nome) {
        this.saldo = this.saldo + valor;
        return true;
    }

    @Override
    public double consultaSaldo() {
        return this.saldo;
    }

    @Override
    public void consultaExtrato(){
        for (Pagamentos Pagamento: this.extrato) {
            System.out.println("Nome: " + Pagamento.getNome());
            System.out.println("Valor: " + Pagamento.getValor());
            System.out.println("Operação: " + Pagamento.getOperacao());
            System.out.println("------------------------------");
        }

        System.out.println("Saldo total: " + this.saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Pagamentos> getExtrato() {
        return extrato;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}
