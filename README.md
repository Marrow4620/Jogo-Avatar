# Jogo-Avatar

Explicação da interface gráfica:

A classe JFrame é utilizada como a janela principal da interface gráfica.
Botões e outros componentes gráficos são adicionados à janela utilizando as classes JLabel, JButton e JPanel.
A classe ActionListener é utilizada para definir a ação a ser executada quando um botão é clicado.
O método setVisible é utilizado para tornar a janela visível na tela.
Explicação da herança:

A classe Personagem é a superclasse e define as propriedades e métodos comuns a todos os personagens.
As classes Aang, Zuko, Katara e Sokka são subclasses de Personagem e herdam as propriedades e métodos da superclasse.
Cada subclasse pode definir seu próprio comportamento para o método atacar.
Explicação do polimorfismo:

O polimorfismo é a capacidade de um objeto ter múltiplas formas.
No exemplo acima, o objeto jogador pode ser uma instância da classe Aang, Zuko, Katara ou Sokka.
O método atacar pode ser chamado em jogador independentemente do tipo de objeto que ele é.
O método atacar chamado será o método definido na subclasse do objeto jogador.
Explicação do objeto:

Um objeto é uma instância de uma classe.
No exemplo acima, aang, zuko, katara e sokka são objetos das classes Aang, Zuko, Katara e Sokka, respectivamente.
Cada objeto tem suas próprias propriedades e comportamento.
Explicação da interface:

Uma interface é um contrato que define um conjunto de métodos que uma classe deve implementar.
No exemplo acima, a interface não é necessária porque o comportamento dos personagens pode ser definido usando herança e polimorfismo.
No entanto, uma interface pode ser útil em outros casos, como quando várias classes precisam implementar o mesmo comportamento.
Explicação dos turnos:

O jogo é dividido em turnos, onde cada jogador pode atacar, defender ou fugir.
O jogador pode atacar o oponente causando dano, defender reduzindo o dano recebido, ou fugir encerrando o jogo.
O computador também pode atacar ou defender aleatoriamente.
Explicação da vitória:

O jogo termina quando um dos personagens chega a 0 de vida, resultando em uma vitória para o outro personagem.
Se o jogador fugir, o jogo termina em empate.
