/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2;

/**
 *
 * @author guilh
 */
public class Katara extends Personagem {
    public Katara() {
        super("Katara", 110, 25, 15);
    }

    @Override
    public void atacar(Personagem oponente) {
        jogadorAtaca(oponente);
    }

    private void jogadorAtaca(Personagem oponente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}