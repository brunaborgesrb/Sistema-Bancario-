public class ContaCorrente extends Conta{
    private int taxaManutencao = 50;

    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, Cliente cliente, int taxaManutencao) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.taxaManutencao = taxaManutencao;
    }

    public int getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(int taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    public double simularOperacao(int meses) {
        for (int i = 0; i < meses; i++) {
            setSaldo(getSaldo() - taxaManutencao);
        }
        return getSaldo();
    }
    
}
