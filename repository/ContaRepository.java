package repository;

import model.Conta;

import java.util.HashMap;
import java.util.Map;

public class ContaRepository {

    private Map<Integer, Conta> contas = new HashMap<>();

    public void salvar(Conta conta) {
        contas.put(conta.getNumero(), conta);
    }

    public Conta buscar(int numero) {
        return contas.get(numero);
    }

    public void listar() {

        contas.values()
                .forEach(c ->
                        System.out.println(
                                "Conta: "
                                        + c.getNumero()
                                        + " | Saldo: "
                                        + c.getSaldo()
                        ));
    }
}