# Aplicações para Internet
## Atividade: Padrões de Projetos

Para cada cenário abaixo, identifique os requisitos e escreva o código em Java das classes e interfaces necessárias para implementar o Padrão de Projeto solicitado. Concentre-se na arquitetura e na relação entre as classes. Você pode usar métodos fictícios (com `System.out.println`) para simular a lógica de negócio, pois o foco é a estrutura do padrão.

---

### 1. Singleton: Gerenciador de Configurações
Seu sistema possui uma classe `ConfiguracaoGlobal` que carrega parâmetros do banco de dados (como URL, porta e timeout). Ler esses dados várias vezes é custoso e pode gerar inconsistências.

* **Tarefa:** Crie a classe `ConfiguracaoGlobal` aplicando o padrão Singleton. Garanta que seja impossível instanciar a classe usando o operador `new` fora dela.

### 2. Strategy: Processador de Pagamentos
Um e-commerce aceita diferentes formas de pagamento: Cartão de Crédito, PayPal e PIX. O cálculo de taxas e o processamento variam para cada um.

* **Tarefa:** Utilizando o padrão Strategy, crie uma interface `EstrategiaPagamento` com um método `processarPagamento(double valor)`. Implemente as três estratégias concretas. Em seguida, crie uma classe `CarrinhoDeCompras` (Contexto) que receba a estratégia desejada dinamicamente e execute o pagamento.

### 3. Factory Method: Emissor de Relatórios
Um software de RH precisa exportar a folha de pagamento em diferentes formatos: PDF, Excel ou HTML.

* **Tarefa:** Aplique o padrão Factory Method. Crie uma interface `Relatorio` com o método `gerar()`. Crie as implementações concretas (Ex: `RelatorioPDF`). Por fim, crie a classe `RelatorioFactory` que recebe uma `String` indicando o tipo desejado e retorna a instância correta do relatório.

### 4. Observer: Alerta de Ações (Bolsa de Valores)
Você está desenvolvendo um sistema de Home Broker. Sempre que o preço da ação da "Empresa X" muda, um aplicativo de celular e um painel web precisam ser atualizados imediatamente.

* **Tarefa:** Use o padrão Observer. Crie a interface `Observer` com o método `atualizar(double novoPreco)`. Crie a classe `Acao` (Subject) que mantém uma lista de observadores e os notifica quando o preço é alterado. Implemente as classes `AppCelular` e `PainelWeb` como observadores.

### 5. Facade: Subsistema de Home Theater
Ligar o sistema de Home Theater para assistir a um filme é complexo: é preciso ligar a TV, ligar o amplificador, definir o volume, ligar o reprodutor de Bluray e apagar as luzes.

* **Tarefa:** Implemente o padrão Facade. Crie as classes dos subsistemas (`TV`, `Amplificador`, `Luzes`, etc.). Depois, crie a classe `HomeTheaterFacade` com um método `assistirFilme()` que orquestra e chama todos os métodos necessários das classes do subsistema de forma sequencial.

### 6. Decorator: Personalização de Hambúrguer
Em uma lanchonete, um hambúrguer base tem um preço e uma descrição. O cliente pode adicionar extras dinamicamente, como Bacon, Queijo e Ovo, que alteram o preço e a descrição final.

* **Tarefa:** Aplique o padrão Decorator. Crie uma interface `Hamburguer` (com métodos `getDescricao()` e `getPreco()`), uma classe concreta `HamburguerBase`. Depois, crie a classe abstrata `HamburguerDecorator` e as classes concretas de ingredientes (`Bacon`, `Queijo`) que envolvem (wrap) o hambúrguer original e somam seus valores.

### 7. Adapter: Integração de APIs de Frete
Seu sistema moderno calcula fretes usando uma interface `CalculadorFrete` com o método `calcular(double peso, double distancia)`. O seu chefe comprou um sistema legado que faz isso através da classe `FreteAntigoXML` usando o método `obterCustoXML(String xmlDados)`.

* **Tarefa:** Implemente o padrão Adapter. Crie a interface moderna, a classe legada (com uma simulação simples) e a classe `FreteAdapter` que implementa `CalculadorFrete`, mas internamente traduz a chamada para o método da classe `FreteAntigoXML`.