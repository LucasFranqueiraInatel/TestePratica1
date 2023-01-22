package br.inatel.banco.services;

import br.inatel.banco.interfaces.IContaCorrenteService;

public class ContaCorrenteService extends ContaBaseService implements IContaCorrenteService
{
    private double credito = 0;

    public ContaCorrenteService(String agencia, String numeroConta) {
        super(agencia, numeroConta);
    }

    @Override
    public void adicionarCredito(double valor){
        this.credito = credito + valor;
    }

    @Override
    public boolean pagarCredito(double valor){
        if (valor <= 0)
            return false;
        this.credito = this.credito - valor;

        return true;
    }

    @Override
    public double consultaCredito(){
        return this.credito;
    }

    @Override
    public void consultaExtrato() {
        super.consultaExtrato();
        System.out.println("Credito total: " + this.credito);
    }
}
