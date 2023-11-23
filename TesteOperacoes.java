import java.util.ArrayList;
import java.util.Scanner;

public class TesteOperacoes {
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Conta> listaContas;

    public TesteOperacoes() {
        this.listaClientes = new ArrayList<>();
        this.listaContas = new ArrayList<>();
    }

    public void criarConta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Informe o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.println("Informe a profissão do cliente: ");
        String profissao = scanner.nextLine();

        Cliente cliente = new Cliente(nome, endereco, profissao);
        listaClientes.add(cliente);

        System.out.println("Informe o tipo de conta (poupança ou corrente): ");
        String tipoConta = scanner.nextLine();

        System.out.println("Informe o número da agência: ");
        int numeroAgencia = scanner.nextInt();

        System.out.println("Informe o número da conta: ");
        int numeroConta = scanner.nextInt();

        System.out.println("Informe o saldo inicial: ");
        double saldo = scanner.nextDouble();

        try {
            Conta conta;
            if (tipoConta.equalsIgnoreCase("poupança")) {
                conta = new ContaPoupanca(numeroAgencia, numeroConta, saldo, cliente, 0.05);
            } else if (tipoConta.equalsIgnoreCase("corrente")) {
                conta = new ContaCorrente(numeroAgencia, numeroConta, saldo, cliente, 50);
            } else {
                throw new IllegalArgumentException("Tipo de conta inválido");
            }
    
            listaContas.add(conta);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Números de agência, conta ou saldo inválidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void realizarOperacoes() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número da agência e conta do remetente: ");
        int agenciaRemetente = scanner.nextInt();
        int contaRemetente = scanner.nextInt();

        System.out.println("Informe o número da agência e conta do destinatário: ");
        int agenciaDestinatario = scanner.nextInt();
        int contaDestinatario = scanner.nextInt();

        Conta remetente = buscarConta(agenciaRemetente, contaRemetente);
        Conta destinatario = buscarConta(agenciaDestinatario, contaDestinatario);

        if (remetente != null && destinatario != null) {
            System.out.println("Informe o valor a ser transferido: ");
            double valor = scanner.nextDouble();
    
            try {
                remetente.transferencia(valor, destinatario);
                System.out.println("Transferência realizada com sucesso.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            System.out.println("Conta do remetente ou destinatário não encontrada.");
        }
    }

    public void exibirSaldo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número da agência e conta do cliente: ");
        int agenciaCliente = scanner.nextInt();
        int contaCliente = scanner.nextInt();

        Conta clienteConta = buscarConta(agenciaCliente, contaCliente);

        if (clienteConta != null) {
            System.out.println("Informe a quantidade de meses para simular o saldo: ");
            int meses = scanner.nextInt();

            clienteConta.exibirSaldo(meses);
        } else {
            System.out.println("Conta do cliente não encontrada.");
        }
    }

    public void apresentarMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Realizar operações");
            System.out.println("3 - Exibir saldo");
            System.out.println("0 - Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    realizarOperacoes();
                    break;
                case 3:
                    exibirSaldo();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private Conta buscarConta(int numeroAgencia, int numeroConta) {
        for (Conta conta : listaContas) {
            if (conta.getNumeroAgencia() == numeroAgencia && conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TesteOperacoes testeOperacoes = new TesteOperacoes();
        testeOperacoes.apresentarMenu();
    }
}
