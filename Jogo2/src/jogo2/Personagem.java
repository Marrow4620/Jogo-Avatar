/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo2;

public abstract class Personagem {
    private String nome;
    private int saude;
    private int dano;
    private int defesa;
    private boolean defendendo; // Novo atributo para rastrear se o personagem está defendendo

    public Personagem(String nome, int saude, int dano, int defesa) {
        this.nome = nome;
        this.saude = saude;
        this.dano = dano;
        this.defesa = defesa;
        this.defendendo = defendendo; // Inicialmente, o personagem não está defendendo
    }

    // Métodos getter e setter para o atributo defendendo
    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }

    // Outros métodos getter e setter
    public String getNome() {
        return nome;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    // Método abstrato para atacar um oponente
    public abstract void atacar(Personagem oponente);
}
