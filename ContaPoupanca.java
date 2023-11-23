public class ContaPoupanca extends Conta {
    private double taxaRendimento = 0.05;

    public ContaPoupanca(int numeroAgencia, int numeroConta, double saldo, Cliente cliente, double taxaRendimento) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public double simularOperacao(int meses) {
        double rendimento = getSaldo();

        for (int i = 0; i < meses; i++) {
            rendimento += taxaRendimento * rendimento;
        }

        return rendimento;
    }

}