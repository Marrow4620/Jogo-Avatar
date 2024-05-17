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
        oponenteSaudeLabel = new JLabel("Saudade do oponente: " + oponente.getSaude());

        atacarButton = new JButton("Atacar");
        atacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogadorAtaca(oponente);
                atualizarLabels();
                computadorResponde();
                verificarVitoria();
            }
        });

        defenderButton = new JButton("Defender");
        defenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogadorDefende();
                atualizarLabels();
                computadorResponde();
                verificarVitoria();
            }
        });

        fugirButton = new JButton("Fugir");
        fugirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Você foge!");
                System.exit(0);
            }
        });

        mensagemLabel = new JLabel("");
    }

    private void atualizarLabels() {
        jogadorSaudeLabel.setText("Sua saúde: " + jogador.getSaude());
        oponenteSaudeLabel.setText("Saudade do oponente: " + oponente.getSaude());
    }

    private void jogadorAtaca(Personagem oponente) {
        int dano = jogador.getDano();
        oponente.setSaude(oponente.getSaude() - dano);
        mensagemLabel.setText("Você atacou " + oponente.getNome() + " causando " + dano + " de dano!");
    }

    private void jogadorDefende() {
        int defesa = jogador.getDefesa();
        jogador.setDano(defesa);
        mensagemLabel.setText("Você defendeu!");
    }

private void computadorResponde() {
    Random random = new Random();
    int escolha = random.nextInt(3);

    if (escolha == 0) {
        int dano = oponente.getDano();
        jogador.setSaude(jogador.getSaude() - dano);
        mensagemLabel.setText(oponente.getNome() + " atacou você causando " + dano + " de dano!");
    } else if (escolha == 1) {
        mensagemLabel.setText(oponente.getNome() + " defendeu!");
    } else {
        // Aqui você pode adicionar outra opção para uma ação diferente, se desejar
    }
}


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
        Personagem aang = new Aang();
        Personagem zuko = new Zuko();
        Personagem katara = new Katara();
        Personagem sokka = new Sokka();

        Jogo jogo = new Jogo(aang, zuko);
        Jogo jogo2 = new Jogo(aang, katara);
        Jogo jogo3 = new Jogo(sokka, zuko);
    }
}
