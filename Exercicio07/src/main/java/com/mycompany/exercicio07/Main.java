/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        
        Scanner teclado = new Scanner(System.in);
        
        Jogador[] jogador = new Jogador[5]; 
        
        for(int i = 0; i < jogador.length; i++) { 
            jogador[i] = new Jogador(); 
            
            System.out.println("--- Jogador " + (i+1) + " ---");
            System.out.print("\nInforme um nome: ");
            jogador[i].setNome(teclado.next()); 
            
            System.out.print("Informe o nivel: ");
            jogador[i].setNivel(teclado.nextInt());
            
            System.out.print("Informe a experiencia: ");
            jogador[i].setExperiencia(teclado.nextInt());
            
            System.out.print("Informe a linha: ");
            int x = teclado.nextInt();
            System.out.print("Informe a coluna: ");
            int y = teclado.nextInt();
            
            System.out.println("");
            
            jogador[i].setPosicao(x, y);
            
            jogadores.add(jogador[i]);
        } 

        System.out.print("Agora informe a posicao para analise..");
        System.out.print("\nInforme a linha: ");
        int x = teclado.nextInt();
        System.out.print("Informe a coluna: ");
        int y = teclado.nextInt();
        
        int posicao[] = {x, y};
        
        System.out.println("\nJogadores proximos:");
        print(jogadores, posicao);
    }
}
