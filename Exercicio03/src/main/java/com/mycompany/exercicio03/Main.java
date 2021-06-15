/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio03;

import java.util.Scanner;

/**
 *
 * @author karla
 */
public class Main {
    public static void main(String[] args) {
    	Scanner teclado = new Scanner(System.in);

    	System.out.println("Nome jogador 1: ");
    	String nomeJ1 = teclado.next();
        
        System.out.println("Pontos de vida jogador 1: ");
    	int pontosVidaJ1 = teclado.nextInt();
        
    	System.out.println("Nível jogador 1: ");
    	int nivelJ1 = teclado.nextInt();

    	System.out.println("Experiência jogador 1: ");
    	int experienciaJ1 = teclado.nextInt();

    	System.out.println("-----------------");

    	System.out.println("Nome jogador 2: ");
    	String nomeJ2 = teclado.next();
        
        System.out.println("Pontos de vida jogador 2: ");
    	int pontosVidaJ2 = teclado.nextInt();
        
    	System.out.println("Nível jogador 2: ");
    	int nivelJ2 = teclado.nextInt();

    	System.out.println("Experiência jogador 2: ");
    	int experienciaJ2 = teclado.nextInt();

    	System.out.println("-----------------");
        
        
        int ataqueJ1, ataqueJ2, defesaJ1, defesaJ2;
    	int rodadas = 1;

    	while (pontosVidaJ1 > 0 && pontosVidaJ2 > 0 && rodadas <= 20) {
            ataqueJ1 = 2 * (nivelJ1 * nivelJ1) * experienciaJ1;
            defesaJ1 = nivelJ1 * (experienciaJ1 * experienciaJ1);
                
            ataqueJ2 = 2 * (nivelJ2 * nivelJ2) * experienciaJ2;
            defesaJ2 = nivelJ2 * (experienciaJ2 * experienciaJ2);

            System.out.println("Rodada: " + rodadas + "\n");
            System.out.println("Ataque: " + nomeJ1 + " --> " + nomeJ2);
                
            if (ataqueJ1 - defesaJ2 > 0) {
                pontosVidaJ2 -= (ataqueJ1 - defesaJ2);
                System.out.println("\t" + nomeJ1 + " venceu!!!");
                System.out.println("\tPontos de vida de " + nomeJ2 + ": " + pontosVidaJ2);

                nivelJ1++;
                ataqueJ1 = 2 * (nivelJ1 * nivelJ1) * experienciaJ1;
                defesaJ1 = nivelJ1 * (experienciaJ1 * experienciaJ1);
                    
                System.out.println("\tNovos dados "+ nomeJ1+ ": ");
                System.out.println("\tNível: " + nivelJ1);
                System.out.println("\tAtaque: " + ataqueJ1);
                System.out.println("\tDefesa: " + defesaJ1);
            } else if (ataqueJ1 - defesaJ2 == 0) {
                nivelJ1++;
                nivelJ2++;
                    
                System.out.println("\tEmpate!");
                System.out.println("\tNovo nivel Jogador "+ nomeJ1+ ": " + nivelJ1);
                System.out.println("\tNovo nivel Jogador "+ nomeJ2+ ": " + nivelJ2);
            } else{
                System.out.println("\t" + nomeJ1 + " nao gerou danos em " + nomeJ2);
            }

            if(pontosVidaJ2 > 0){
                 System.out.println("\nAtaque: " + nomeJ2 + " --> " + nomeJ1);

                if (ataqueJ2 - defesaJ1 > 0) {
                    pontosVidaJ1 -= (ataqueJ2 - defesaJ1);

                    System.out.println("\t" + nomeJ2 + " venceu!!!");
                    System.out.println("\tPontos de vida de " + nomeJ1 + ": " + pontosVidaJ1);

                    nivelJ2++;
                    ataqueJ2 = 2 * (nivelJ2 * nivelJ2) * experienciaJ2;
                    defesaJ2 = nivelJ2 * (experienciaJ2 * experienciaJ2);

                    System.out.println("\tNovos dados " + nomeJ2 + ": ");
                    System.out.println("\tNível: " + nivelJ2);
                    System.out.println("\tAtaque: " + ataqueJ2);
                    System.out.println("\tDefesa: " + defesaJ2 + "\n");
                } else if (ataqueJ1 - defesaJ2 == 0) {
                    nivelJ1++;
                    nivelJ2++;

                    System.out.println("\tEmpate!");
                    System.out.println("\tNovo nivel Jogador " + nomeJ1 + ": " + nivelJ1);
                    System.out.println("\tNovo nivel Jogador " + nomeJ2 + ": " + nivelJ2 + "\n");

                } else {
                    System.out.println("\t" + nomeJ2 + " nao gerou danos em " + nomeJ1 + "\n");
                }
            }
           
            rodadas++;
        }
    }
}
