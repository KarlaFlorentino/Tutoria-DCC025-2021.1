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
        
        System.out.print("Nome jogador 1: ");
        String nome_j1 = teclado.next();
        
        System.out.print("Nível jogador 1: ");
        int nivel_j1 = teclado.nextInt();
        
        System.out.print("Experiência jogador 1: ");
        int experiencia_j1 = teclado.nextInt();
        
        System.out.println("-----------------");
        
        System.out.print("Nome jogador 2: ");
        String nome_j2 = teclado.next();
        
        System.out.print("Nível jogador 2: ");
        int nivel_j2 = teclado.nextInt();
        
        System.out.print("Experiência jogador 2: ");
        int experiencia_j2 = teclado.nextInt();
        
        System.out.println("-----------------");
        
        int ataque_j1 = 2 * (nivel_j1 ^ 2) * experiencia_j2;
        int defesa_j1 = nivel_j1 * (experiencia_j1 ^2);
        
        int ataque_j2 = 2 * (nivel_j2 ^ 2) * experiencia_j2;
        int defesa_j2 = nivel_j2 * (experiencia_j2 ^2);
        
        if(ataque_j1 - defesa_j2 > 0){
            System.out.println(nome_j1);
        }else if(ataque_j2 - defesa_j1 > 0){
            System.out.println(nome_j2);
        }else{
            System.out.println("Empate!");
        }
    }
}
