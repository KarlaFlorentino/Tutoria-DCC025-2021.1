/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio07;

import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class Jogador {
    private String nome;
    private int posicao[] = new int[2];
    private int nivel = 1;
    private int experiencia = 1;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getPosicao() {
        return posicao;
    }

    public void setPosicao(int x, int y) {
        this.posicao[0] = x;
        this.posicao[1] = y;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void imprime() {
        JOptionPane.showMessageDialog(null, "Nome: " + this.nome + "\n"
                + "Posição: (" + this.posicao[0] + ", " + this.posicao[1] + ")\n"
                + "Nível: " + this.nivel + "\n"
                + "Experiência: " + this.experiencia);
    }
}
