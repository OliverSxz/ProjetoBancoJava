package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    private static int SEQUENCIAL = 1000;

    protected int numero;
    protected Cliente cliente;
    protected double saldo;

    protected List<Transacao> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.numero = ++SEQUENCIAL;
        this.cliente = cliente;
    }

    public void depositar(double valor) {

        if (valor <= 0)
            throw new IllegalArgumentException("Valor inválido");

        saldo += valor;

        historico.add(
                new Transacao(
                        TipoTransacao.DEPOSITO,
                        valor
                )
        );
    }

    public void sacar(double valor) {

        if (valor > saldo)
            throw new RuntimeException("Saldo insuficiente");

        saldo -= valor;

        historico.add(
                new Transacao(
                        TipoTransacao.SAQUE,
                        valor
                )
        );
    }

    public void transferir(double valor, Conta destino) {

        sacar(valor);

        destino.saldo += valor;

        historico.add(
                new Transacao(
                        TipoTransacao.TRANSFERENCIA_ENVIADA,
                        valor
                )
        );

        destino.historico.add(
                new Transacao(
                        TipoTransacao.TRANSFERENCIA_RECEBIDA,
                        valor
                )
        );
    }

    public void exibirExtrato() {

        System.out.println("\n========================");
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Conta: " + numero);
        System.out.println("Saldo: R$ " + saldo);

        System.out.println("\nHistórico:");

        for (Transacao t : historico) {
            System.out.println(t);
        }

        System.out.println("========================");
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}