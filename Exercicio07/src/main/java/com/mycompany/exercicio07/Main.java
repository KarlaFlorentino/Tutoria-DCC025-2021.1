/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio07;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karla
 */
public class Main {
    public static <T> void print(List<? extends Jogador> elements, int[] posicao){
        for(Jogador j : elements){
            if(j.getPosicao()[0] >= (posicao[0] - 2) && j.getPosicao()[0] <= (posicao[0] + 2) &&
               j.getPosicao()[1] >= (posicao[0] - 2) && j.getPosicao()[1] <= (posicao[0] + 2) ){
                
                System.out.println(j.getNome());
            }
        }
    }
    
    
    public static void main(String[] args) {
        List<Jogador> jogadores = new ArrayList<Jogador>();
        
        Jogador jogador1 = new Jogador();
        jogador1.setNome("J1"); jogador1.setPosicao(4, 2);
        jogadores.add(jogador1);
        
        Jogador jogador2 = new Jogador();
        jogador2.setNome("J2"); jogador2.setPosicao(6, 3);
        jogadores.add(jogador2);
        
        Jogador jogador3 = new Jogador();
        jogador3.setNome("J3"); jogador3.setPosicao(1, 5);
        jogadores.add(jogador3);
        
        Jogador jogador4 = new Jogador();
        jogador4.setNome("J4"); jogador4.setPosicao(0, 0);
        jogadores.add(jogador4);
        
        Jogador jogador5 = new Jogador();
        jogador5.setNome("J5"); jogador5.setPosicao(7, 7);
        jogadores.add(jogador5);
        
        int posicao[] = {3, 3};
        
        print(jogadores, posicao);
    }
}
