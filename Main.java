import repository.ContaRepository;
import service.BancoService;
import model.Conta;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ContaRepository repository =
                new ContaRepository();

        BancoService banco =
                new BancoService(repository);

        while (true) {

            System.out.println("\n===== BANCO JAVA =====");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Extrato");
            System.out.println("6 - Listar contas");
            System.out.println("0 - Sair");

            int op = sc.nextInt();

            try {

                switch (op) {

                    case 1:

                        sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        Conta conta =
                                banco.criarConta(nome, cpf);

                        System.out.println(
                                "Conta criada: "
                                        + conta.getNumero());

                        break;

                    case 2:

                        System.out.print("Conta: ");
                        int c1 = sc.nextInt();

                        System.out.print("Valor: ");
                        double v1 = sc.nextDouble();

                        banco.depositar(c1, v1);

                        break;

                    case 3:

                        System.out.print("Conta: ");
                        int c2 = sc.nextInt();

                        System.out.print("Valor: ");
                        double v2 = sc.nextDouble();

                        banco.sacar(c2, v2);

                        break;

                    case 4:

                        System.out.print("Origem: ");
                        int origem = sc.nextInt();

                        System.out.print("Destino: ");
                        int destino = sc.nextInt();

                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();

                        banco.transferir(
                                origem,
                                destino,
                                valor);

                        break;

                    case 5:

                        System.out.print("Conta: ");
                        banco.extrato(sc.nextInt());

                        break;

                    case 6:

                        banco.listarContas();

                        break;

                    case 0:

                        System.exit(0);
                }

            } catch (Exception e) {

                System.out.println(
                        "Erro: " + e.getMessage());
            }
        }
    }
}