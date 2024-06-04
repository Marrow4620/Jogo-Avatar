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
        int dano = this.getDano();
        if (oponente.isDefendendo()) {
            dano /= 2; // dano é reduzido pela metade se o oponente está defendendo
        }
        oponente.setSaude(oponente.getSaude() - dano);
        oponente.setDefendendo(false); // resetar o estado de defesa do oponente após ser atacado
    }
}
