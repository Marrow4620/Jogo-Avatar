/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2;

/**
 *
 * @author guilh
 */
public class Zuko extends Personagem {
    public Zuko() {
        super("Zuko", 100, 15, 10);
    }

    @Override
    public void atacar(Personagem oponente) {
        if (!oponente.isDefendendo()) {
            int dano = this.getDano();
            oponente.setSaude(oponente.getSaude() - dano);
        }
    }
}
