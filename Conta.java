public class Conta {
    private int numeroAgencia, numeroConta;
    private double saldo;
    private Cliente cliente;

    public Conta(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void deposito(double dinheiro) {
        if (dinheiro < 0) {
            System.out.println("Inválido para depósito.");
        } else {
            saldo += dinheiro;
            System.out.println("Depósito realizado.");
        }
    }

    public void saque(double dinheiro) {
        if (dinheiro > 0 && dinheiro <= saldo) {
            saldo -= dinheiro;
            System.out.println("Saque realizado.");
        } else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public void transferencia(double dinheiro, Conta transferir) {
        if (dinheiro > 0 && dinheiro <= saldo) {
            saldo -= dinheiro;
            transferir.deposito(dinheiro);
        } else {
            System.out.println("Não foi possível realizar a transferência.");
        }
    }

    public void exibirSaldo(int meses) {
        System.out.println("O cliente " + cliente.getNome() + " possui este saldo: " + getSaldo());
    }
}