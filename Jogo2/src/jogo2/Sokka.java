/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2;

/**
 *
 * @author guilh
 */
public class Sokka extends Personagem {
    public Sokka() {
super("Sokka", 90, 15, 25);
    }

    @Override
    public void atacar(Personagem oponente) {
        jogadorAtaca(oponente);
    }

    private void jogadorAtaca(Personagem oponente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}