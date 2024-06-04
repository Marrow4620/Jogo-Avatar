/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Jogo extends JFrame {
    private Personagem jogador;
    private Personagem oponente;
    private JLabel jogadorSaudeLabel;
    private JLabel oponenteSaudeLabel;
    private JButton atacarButton;
    private JButton defenderButton;
    private JButton fugirButton;
    private JLabel mensagemLabel;

    public Jogo(Personagem jogador, Personagem oponente) {
        this.jogador = jogador;
        this.oponente = oponente;

        inicializarComponentes();
        configurarJanela();
    }

    private void inicializarComponentes() {
        jogadorSaudeLabel = new JLabel("Sua saúde: " + jogador.getSaude());
        oponenteSaudeLabel = new JLabel("Saúde do oponente: " + oponente.getSaude());

        atacarButton = new JButton("Atacar");
        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.setDefendendo(false); // jogador não está defendendo
                jogadorAtaca(oponente);
                atualizarLabels();
                computadorResponde();
                atualizarLabels();
                verificarVitoria();
            }
        });

        defenderButton = new JButton("Defender");
        defenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogador.setDefendendo(true); // jogador está defendendo
                mensagemLabel.setText("Você se defendeu!");
                atualizarLabels();
                computadorResponde();
                atualizarLabels();
                verificarVitoria();
            }
        });

        fugirButton = new JButton("Fugir");
        fugirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Você fugiu!");
                System.exit(0);
            }
        });

        mensagemLabel = new JLabel("");
    }

    private void atualizarLabels() {
        jogadorSaudeLabel.setText("Sua saúde: " + jogador.getSaude());
        oponenteSaudeLabel.setText("Saúde do oponente: " + oponente.getSaude());
    }

private void jogadorAtaca(Personagem oponente) {
    int dano = jogador.getDano();
    if (oponente.isDefendendo()) {
        dano /= 2; // dano é reduzido pela metade se o oponente está defendendo
        mensagemLabel.setText(oponente.getNome() + " se defendeu, mas você atacou causando " + dano + " de dano!");
    } else {
        mensagemLabel.setText("Você atacou " + oponente.getNome() + " causando " + dano + " de dano!");
    }
    oponente.setSaude(oponente.getSaude() - dano);
    oponente.setDefendendo(false); // resetar o estado de defesa do oponente após ser atacado
}

// Atualize o método jogadorDefende para não alterar o dano
private void jogadorDefende() {
    jogador.setDefendendo(true); // jogador está defendendo
    mensagemLabel.setText("Você se defendeu!");
}

private void computadorResponde() {
    Random random = new Random();
    int escolha = random.nextInt(2);
    int dano = 0; // Declare a variável dano fora do bloco if

    if (escolha == 0) {
        dano = oponente.getDano(); // Atribua um valor à variável dano dentro do bloco if
        if (jogador.isDefendendo()) {
            dano /= 2; // dano é reduzido pela metade se o jogador está defendendo
            mensagemLabel.setText(oponente.getNome() + " atacou você causando " + dano + " de dano! Você se defendeu!");
        } else {
            mensagemLabel.setText(oponente.getNome() + " atacou você causando " + dano + " de dano!");
        }
        jogador.setSaude(jogador.getSaude() - dano);
    } else {
        oponente.setDefendendo(true);
        mensagemLabel.setText(oponente.getNome() + " se defendeu! mas vc atacou causando " + dano); 
        // Agora a variável dano pode ser usada aqui
    }
}

// Remover reset de estado de defesa do oponente no método computadorResponde

    private void verificarVitoria() {
        if (jogador.getSaude() <= 0) {
            System.out.println("Você perdeu!");
            System.exit(0);
        } else if (oponente.getSaude() <= 0) {
            System.out.println("Você venceu!");
            System.exit(0);
        }
    }

    private void configurarJanela() {
        setLayout(new GridLayout(4, 1));
        add(jogadorSaudeLabel);
        add(oponenteSaudeLabel);
        JPanel botoesPanel = new JPanel();
        botoesPanel.add(atacarButton);
        botoesPanel.add(defenderButton);
        botoesPanel.add(fugirButton);
        add(botoesPanel);
        add(mensagemLabel);

        setTitle("Avatar: A Lenda de Aang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        Personagem[] personagens = { new Aang(), new Zuko(), new Katara(), new Sokka() };
        String[] nomesPersonagens = { "Aang", "Zuko", "Katara", "Sokka" };

        String jogadorNome = (String) JOptionPane.showInputDialog(
                null,
                "Escolha seu personagem",
                "Seleção de Personagem",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nomesPersonagens,
                nomesPersonagens[0]);

        String oponenteNome = (String) JOptionPane.showInputDialog(
                null,
                "Escolha o oponente",
                "Seleção de Personagem",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nomesPersonagens,
                nomesPersonagens[1]);

        Personagem jogador = null;
        Personagem oponente = null;

        for (Personagem personagem : personagens) {
            if (personagem.getNome().equals(jogadorNome)) {
                jogador = personagem;
            }
            if (personagem.getNome().equals(oponenteNome)) {
                oponente = personagem;
            }
        }

        if (jogador != null && oponente != null) {
            new Jogo(jogador, oponente);
        } else {
            System.out.println("Personagem inválido selecionado!");
        }
    }
}
