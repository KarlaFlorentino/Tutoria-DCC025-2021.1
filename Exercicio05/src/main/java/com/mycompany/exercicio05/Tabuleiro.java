/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio05;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author karla
 */
public class Tabuleiro {
    
        public static void coletar(Jogador jogador){
            char opcao = JOptionPane.showInputDialog("Parabéns, você encontrou um tesouro! Deseja coletar(s/n)? ").charAt(0);
            switch(opcao){
                case 's':
                    jogador.setExperiencia(jogador.getExperiencia() + 1);
                    break;
                case 'n':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
        
        public static void desafiar(Jogador jogador, Jogador oponente){
            char opcaoJ1 = JOptionPane.showInputDialog("Você deseja desafiar "+ oponente.getNome()+" para um confronto(s/n)? ").charAt(0);
            switch(opcaoJ1){
                case 's':
                    char opcaoJ2 = JOptionPane.showInputDialog(oponente.getNome() + ", você foi desafiado para um confronto. Aceita o desafio(s/n)?").charAt(0);
                    
                    if(opcaoJ2 == 's'){
                        int diferencaTurno1 = jogador.getForcaAtaque() - oponente.getForcaDefesa();
                        if(diferencaTurno1 > 0){
                            jogador.setNivel(jogador.getNivel() + 1);
                            jogador.setPontosVida(50);

                            oponente.setPontosVida(oponente.getPontosVida() - 1);
                        }else if(diferencaTurno1 == 0){
                            jogador.setNivel(jogador.getNivel() + 1);
                            jogador.setPontosVida(50);

                            oponente.setNivel(oponente.getNivel() + 1);
                            oponente.setPontosVida(50);
                        }else{
                            jogador.setPontosVida(jogador.getPontosVida() - 1);
                        }
                        
                        int diferencaTurno2 = oponente.getForcaAtaque() - jogador.getForcaDefesa();
                        if(diferencaTurno2 > 0){
                            oponente.setNivel(oponente.getNivel() + 1);
                            oponente.setPontosVida(50);

                            jogador.setPontosVida(jogador.getPontosVida() - 1);
                        }else if(diferencaTurno2 == 0){
                            oponente.setNivel(oponente.getNivel() + 1);
                            oponente.setPontosVida(50);
                            
                            jogador.setNivel(jogador.getNivel() + 1);
                            jogador.setPontosVida(50);
                        }else{
                            oponente.setPontosVida(oponente.getPontosVida() - 1);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }
                    
                    JOptionPane.showMessageDialog(null, jogador.imprime());
                    JOptionPane.showMessageDialog(null, oponente.imprime());
        
                    break;
                case 'n':
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    
        public static void locomover(Jogador jogador, Jogador oponente, char matriz[][], int ordem){
        char opcao = JOptionPane.showInputDialog("Digite:\n"
                +                                "w - para mover o jogador para cima;\n"
                +                                "s - para mover o jogador para baixo;\n"
                +                                "a - para mover o jogador para esquerda;\n"
                +                                "d - para mover o jogador para direita. \n" + 
                                                 "Informe a direção: ").charAt(0);
        
        int x = jogador.getPosicao()[0];
        int y = jogador.getPosicao()[1];
        
        switch(opcao){
            case 'w':
                if((x - 1) >= 0){
                    if( matriz[x - 1][y] == 'T') coletar(jogador);
                    else if( matriz[x - 1][y] == oponente.getNome().charAt(0)) desafiar(jogador, oponente);
                    else JOptionPane.showMessageDialog(null, "Não foi dessa vez! Boa sorte na próxima jogada.");
                    
                    matriz[x][y] = ' ';
                    matriz[x - 1][y] = jogador.getNome().charAt(0);
                    jogador.setPosicao(x - 1, y);
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            case 's':
                if((x + 1) < ordem){
                    if(matriz[x + 1][y] == 'T') coletar(jogador);
                    else if( matriz[x + 1][y] == oponente.getNome().charAt(0)) desafiar(jogador, oponente);
                    else JOptionPane.showMessageDialog(null, "Não foi dessa vez! Boa sorte na próxima jogada.");
                    
                    matriz[x][y] = ' ';
                    matriz[x + 1][y] = jogador.getNome().charAt(0);
                    jogador.setPosicao(x + 1, y);
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            case 'a':
                if((y - 1) >= 0){
                    if( matriz[x][y - 1] == 'T') coletar(jogador);
                    else if( matriz[x][y - 1] == oponente.getNome().charAt(0)) desafiar(jogador, oponente);
                    else JOptionPane.showMessageDialog(null, "Não foi dessa vez! Boa sorte na próxima jogada.");
                    
                    matriz[x][y] = ' ';
                    matriz[x][y - 1] = jogador.getNome().charAt(0);
                    jogador.setPosicao(x, y - 1);
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            case 'd':
                if((y + 1) < ordem){
                    if( matriz[x][y + 1] == 'T') coletar(jogador);
                    else if( matriz[x][y + 1] == oponente.getNome().charAt(0)) desafiar(jogador, oponente);
                    else JOptionPane.showMessageDialog(null, "Não foi dessa vez! Boa sorte na próxima jogada.");
                    
                    matriz[x][y] = ' ';
                    matriz[x][y + 1] = jogador.getNome().charAt(0);
                    jogador.setPosicao(x, y + 1);
                }else{
                    JOptionPane.showMessageDialog(null, "Direção inválida!");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Direção inválida!");
        }   
    }
    
    
    public static void main(String[] args) {
        int ordem = 20;
        char matriz[][] = new char[ordem][ordem]; 
         
        Jogador jogador1 = new Jogador(); 
        jogador1.setNome(JOptionPane.showInputDialog("Informe um nome para o jogador 1: "));
        
        Jogador jogador2 = new Jogador();
        jogador2.setNome(JOptionPane.showInputDialog("Informe um nome para o jogador 2: "));
            
        Random r = new Random();
        int linha, coluna;
            
        linha = r.nextInt(ordem);
        coluna = r.nextInt(ordem);
        jogador1.setPosicao(linha, coluna);
        matriz[linha][coluna] = jogador1.getNome().charAt(0);
        
        linha = r.nextInt(ordem);
        coluna = r.nextInt(ordem);
        jogador2.setPosicao(linha, coluna);
        matriz[linha][coluna] = jogador2.getNome().charAt(0);
      
        
        int tesouros = 80, contT = 0;
        while(contT != tesouros){
            linha = r.nextInt(ordem);
            coluna = r.nextInt(ordem);
            if((int)(matriz[linha][coluna]) == 0){
                matriz[linha][coluna] = 'T';
                contT ++;
            }
        }
        
        int opcaoJ1 = 0, opcaoJ2 = 0;
        while(opcaoJ1 != 3 || opcaoJ2 != 3){
            for(int i = 0; i < ordem; i++){
                for(int j = 0; j < ordem; j++){
                    System.out.print("\t" + matriz[i][j] + "|");
                }
                System.out.println("");
            }
            System.out.println("------------------------------");

            
            if(opcaoJ1 != 3){
                if(jogador1.getPontosVida() < 1){
                    JOptionPane.showMessageDialog(null, jogador1.getNome() + " zerou os pontoa de vida!");
                    opcaoJ1 = 3;
                }else{
                    opcaoJ1 = Integer.parseInt(JOptionPane.showInputDialog(jogador1.getNome() 
                        +                                            "\nDigite:\n"
                        +                                            "1 - Para movimentar\n"
                        +                                            "2 - Para ajuda\n"  
                        +                                            "3 - Para sair\n" 
                        +                                            "Informe a opção: "));
                    if(opcaoJ1 == 1){
                       locomover(jogador1, jogador2, matriz, ordem);
                    }else if(opcaoJ1 == 2){
                        JOptionPane.showMessageDialog(null, Jogador.ajuda());
                    }else if(opcaoJ1 == 0 || opcaoJ1 > 3){
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                    }
                }
            }else{
                matriz[jogador1.getPosicao()[0]][jogador1.getPosicao()[1]] = ' ';
            }
            
            
            for(int i = 0; i < ordem; i++){
                for(int j = 0; j < ordem; j++){
                    System.out.print("\t" + matriz[i][j] + "|");
                }
                System.out.println("");
            }
            System.out.println("------------------------------");
            
            if(opcaoJ2 != 3){
                opcaoJ2 = Integer.parseInt(JOptionPane.showInputDialog(jogador2.getNome() 
                    +                                            "\nDigite:\n"
                    +                                            "1 - Para movimentar\n"
                    +                                            "2 - Para ajuda\n"  
                    +                                            "3 - Para sair\n" 
                    +                                            "Informe a opção: "));
                if(opcaoJ2 == 1){
                   locomover(jogador2, jogador1, matriz, ordem);
                }else if(opcaoJ2 == 2){
                   JOptionPane.showMessageDialog(null, Jogador.ajuda());
                }else if(opcaoJ2 == 0 || opcaoJ2 > 3){
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            }else{
                matriz[jogador2.getPosicao()[0]][jogador2.getPosicao()[1]] = ' ';
            }
        }
        
        JOptionPane.showMessageDialog(null, jogador1.imprime());
        JOptionPane.showMessageDialog(null, jogador2.imprime());
        System.exit(0);
    }
}
