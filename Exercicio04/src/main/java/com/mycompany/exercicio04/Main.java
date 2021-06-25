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
        int achouTesouro = 3; // 0 - não achou 1 - achou 3 - direção invalida
        char opcao = JOptionPane.showInputDialog("w - cima; s - baixo; a - esquerda; d - direita. \n" + "Informe a dureção: ").charAt(0);
        switch(opcao){
            case 'w':
                if((posicaoAtual[0] - 1) >= 0){
                    if( matriz[posicaoAtual[0] - 1][posicaoAtual[1]] == 'T') achouTesouro =  1;
                    else achouTesouro =  0;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0] - 1][posicaoAtual[1]] = 'J';
                    posicaoAtual[0] = posicaoAtual[0] - 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            case 's':
                if((posicaoAtual[0] + 1) < ordem){
                    if(matriz[posicaoAtual[0] + 1][posicaoAtual[1]] == 'T') achouTesouro =  1;
                    else achouTesouro =  0;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0] + 1][posicaoAtual[1]] = 'J';
                    posicaoAtual[0] = posicaoAtual[0] + 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            case 'a':
                if((posicaoAtual[1] - 1) >= 0){
                    if( matriz[posicaoAtual[0]][posicaoAtual[1] - 1] == 'T') achouTesouro =  1;
                    else achouTesouro =  0;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0]][posicaoAtual[1] - 1] = 'J';
                    posicaoAtual[1] = posicaoAtual[1] - 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            case 'd':
                if((posicaoAtual[1] + 1) < ordem){
                    if( matriz[posicaoAtual[0]][posicaoAtual[1] + 1] == 'T') achouTesouro =  1;
                    else achouTesouro =  0;
                    
                    matriz[posicaoAtual[0]][posicaoAtual[1]] = ' ';
                    matriz[posicaoAtual[0]][posicaoAtual[1] + 1] = 'J';
                    posicaoAtual[1] = posicaoAtual[1] + 1;
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Direção inválida!");
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
        
        /*for(int i = 0; i < ordem; i++){
            for(int j = 0; j < ordem; j++){
                System.out.print(matriz[i][j] + " | ");
            }
        
            System.out.println("");
        }
        System.out.println("---------------");*/
        
        int pontuacaoMax = experiencia + tesouros;
        int opcao = 0;
        while (experiencia != pontuacaoMax && opcao != 2){
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Locomoção 2 - Sair \n" + "Informe a opção: "));
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
