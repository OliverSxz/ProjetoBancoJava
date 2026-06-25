package service;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import repository.ContaRepository;

public class BancoService {

    private ContaRepository repository;

    public BancoService(ContaRepository repository) {
        this.repository = repository;
    }

    public Conta criarConta(String nome, String cpf) {

        Cliente cliente =
                new Cliente(nome, cpf);

        Conta conta =
                new ContaCorrente(cliente);

        repository.salvar(conta);

        return conta;
    }

    public void depositar(int conta, double valor) {

        repository
                .buscar(conta)
                .depositar(valor);
    }

    public void sacar(int conta, double valor) {

        repository
                .buscar(conta)
                .sacar(valor);
    }

    public void transferir(
            int origem,
            int destino,
            double valor) {

        Conta c1 = repository.buscar(origem);
        Conta c2 = repository.buscar(destino);

        c1.transferir(valor, c2);
    }

    public void extrato(int conta) {

        repository
                .buscar(conta)
                .exibirExtrato();
    }

    public void listarContas() {
        repository.listar();
    }
}