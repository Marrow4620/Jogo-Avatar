/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2;

/**
 *
 * @author guilh
 */


public class Aang extends Personagem {
    public Aang() {
        super("Aang", 100, 20, 10);
    }

    @Override
    public void atacar(Personagem oponente) {
        if (!oponente.isDefendendo()) {
            int dano = this.getDano();
            oponente.setSaude(oponente.getSaude() - dano);
        }
    }
}
