/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio04;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class Main {
    public static int novaExperiencia(int experiencia){       
        return experiencia += 1;
    }
    public static int locomover(char matriz[][], int ordem, int posicaoAtual[]){
        int achouTesouro = 0; 
        char opcao = JOptionPane.showInputDialog("Digite:\n"
                +                                "w - para mover o jogador para cima;\n"
                +                                "s - para mover o jogador para baixo;\n"
                +                                "a - para mover o jogador para esquerda;\n"
                +                                "d - para mover o jogador para direita. \n" + 
                                                 "Informe a direção: ").charAt(0);
        switch(opcao){
            case 'w':
                if((posicaoAtual[0] - 1) >= 0){
                    if( matriz[posicaoAtual[0] - 1][posicaoAtual[1]] == 'T') achouTesouro = 1;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0] - 1][posicaoAtual[1]] = 'J';
                    posicaoAtual[0] = posicaoAtual[0] - 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                    achouTesouro = -1;
                }
                break;
            case 's':
                if((posicaoAtual[0] + 1) < ordem){
                    if(matriz[posicaoAtual[0] + 1][posicaoAtual[1]] == 'T') achouTesouro = 1;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0] + 1][posicaoAtual[1]] = 'J';
                    posicaoAtual[0] = posicaoAtual[0] + 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                    achouTesouro = -1;
                }
                break;
            case 'a':
                if((posicaoAtual[1] - 1) >= 0){
                    if( matriz[posicaoAtual[0]][posicaoAtual[1] - 1] == 'T') achouTesouro = 1;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0]][posicaoAtual[1] - 1] = 'J';
                    posicaoAtual[1] = posicaoAtual[1] - 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                    achouTesouro = -1;
                }
                break;
            case 'd':
                if((posicaoAtual[1] + 1) < ordem){
                    if( matriz[posicaoAtual[0]][posicaoAtual[1] + 1] == 'T') achouTesouro = 1;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0]][posicaoAtual[1] + 1] = 'J';
                    posicaoAtual[1] = posicaoAtual[1] + 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                    achouTesouro = -1;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Direção inválida!");
                achouTesouro = -1;
        }   
        
        return achouTesouro;
    }
    
    public static void main(String[] args) {
    	int ordem = Integer.parseInt(JOptionPane.showInputDialog("Informe a ordem da matriz (N x N): "));
    	int tesouros = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de tesouros: "));
    	String nome = JOptionPane.showInputDialog("Informe o nome do jogador: ");        
    	int experiencia = Integer.parseInt(JOptionPane.showInputDialog("Informe os pontos de experiência do jogador: "));
        
        char matriz[][] = new char[ordem][ordem]; 
        matriz[0][0] = 'J';
        int posicaoAtual[] = {0,0};
         
        Random r = new Random();
        int cont = 0;
        while(cont != tesouros){
            int linha = r.nextInt(ordem);
            int coluna = r.nextInt(ordem);
            if((int)(matriz[linha][coluna]) == 0){
                matriz[linha][coluna] = 'T';
                cont ++;
            }
        }
        
        int pontuacaoMax = experiencia + tesouros;
        int opcao = 0;
        while (experiencia != pontuacaoMax && opcao != 2){
            for(int i = 0; i < ordem; i++){
                for(int j = 0; j < ordem; j++){
                    System.out.print(matriz[i][j] + "|");
                }
                System.out.println("");
            }
            System.out.println("---------------");
        
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n "
                    +                                            "1 - Para movimentar o Jogador\n "
                    +                                            "2 - Para sair\n" + 
                                                                 "Informe a opção: "));
            if(opcao == 1){
                int aux = locomover(matriz, ordem, posicaoAtual);
                
                if(aux == 1){
                    experiencia = novaExperiencia(experiencia);
                    JOptionPane.showMessageDialog(null, "Parabéns, você encontrou um tesouro! Nova  pontuação de experiência: " + experiencia+ ".");
                }else if(aux == 0){
                    JOptionPane.showMessageDialog(null, "Não foi dessa vez! Boa sorte na próxima jogada.");
                }
            }else if(opcao == 0 || opcao > 2){
                JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
        
        if(experiencia == pontuacaoMax){
            JOptionPane.showMessageDialog(null, "O jogador encontrou todos os tesouros.");
        }
        JOptionPane.showMessageDialog(null, "O jogador " + nome + " se encontra na posição (" + posicaoAtual[0] + ", " + posicaoAtual[1] +") e sua pontuação de experiência é " + experiencia + ".");
        System.exit(0);
    }                 
}
