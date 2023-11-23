# Desafio de Implementação: Sistema Bancário em Java 👩‍💻​
Este projeto tem como objetivo a implementação de um sistema bancário em Java, utilizando os conceitos de programação orientada a objetos. O sistema será composto por diferentes classes que representam entidades como Cliente, Conta, ContaPoupanca, ContaCorrente, e TesteOperacoes.

Especificações das Classes:
# 1. Cliente
   
**Atributos Privados:**

•nome
•endereço
•profissão

**Métodos:**

•Getters e setters para cada atributo.

•exibirAtributos(): exibe na tela todos os atributos do cliente.

# 2. Conta
   
**Atributos Privados:**

•número da agência
•número da conta
•saldo
•cliente (objeto do tipo Cliente)

**Métodos:**

•Getters e setters para cada atributo.

•deposito(double valor): recebe uma quantia de dinheiro e adiciona ao saldo da conta.

•saque(double valor): remove uma quantia de dinheiro e retira do saldo da conta.

•transferencia(Conta contaDestino): recebe como parâmetro uma conta de destino e transfere uma quantia do saldo da conta atual para a conta destino.

•exibirSaldo(): apresenta uma mensagem de texto informando o nome do usuário e o saldo na conta.

# 3. ContaPoupanca (Subclasse de Conta)
   
**Atributo Adicional:**

•taxaRendimento (valor fixo de 0.05)

**Método Adicional:**

•simularOperacao(int meses): recebe um número inteiro representando a quantidade de meses desejados para simular o rendimento da conta poupança. Retorna o rendimento do saldo atual de acordo com a taxa de rendimento.

# 4. ContaCorrente (Subclasse de Conta)
   
**Atributo Adicional:**

•taxaManutencao (valor fixo de 50 reais)

**Método Adicional:**

•simularOperacao(int meses): recebe um número inteiro representando a quantidade de meses desejados para simular o valor de custo das operações da conta corrente. Retorna o saldo final após o decrescimento da taxa de manutenção mensal.

# 5. TesteOperacoes
   
**Atributos:**

•listaClientes (ArrayList para armazenar todos os clientes criados)

•listaContas (ArrayList para armazenar todas as contas criadas)

**Métodos:**

•criarConta(): Cria uma nova conta a partir das informações fornecidas pelo usuário.

•realizarOperacoes(): Realiza operações entre contas, como transferências.

•exibirSaldo(): Exibe o saldo de uma conta específica.
