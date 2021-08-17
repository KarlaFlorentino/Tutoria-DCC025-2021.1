/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author karla
 */
public class Main {
    public static void main(String[] args) {
        Map <String, Servidor> servidores = new HashMap <String, Servidor>();
        
        Scanner teclado = new Scanner(System.in);

        int opcao = 0;
        
        do{
            System.out.print("Digite:\n"
                +                                "1 - Adicionar;\n"
                +                                "2 - Remover;\n"
                +                                "3 - Listar;\n"
                +                                "4 - Encerrar. \n" + 
                                                 "Informe a opção: ");
            opcao = teclado.nextInt();
            
            System.out.println("");
            
            switch(opcao){
                case 1:
                    
                    System.out.print("Informe o IP: ");
                    String ip = teclado.next();
                    
                    String link;
                    do{
                       System.out.print("Informe o link: ");
                       link = teclado.next();
                       if(servidores.containsKey(link)) System.out.println("Link inválido!");
                    }while(servidores.containsKey(link) != false);
                    
                    System.out.print("Informe a região: ");
                    teclado.nextLine();
                    String regiao = teclado.nextLine();

                    System.out.print("Informe o idioma: ");
                    String idioma = teclado.next();

                    Servidor servidor = new Servidor(ip, regiao, idioma, link);
                    
                    servidores.put(link, servidor);
                    
                    System.out.println("");
                    break;
                case 2:
                    if(!servidores.isEmpty()){
                        System.out.print("Informe a chave(link): ");
                        teclado.nextLine();
                        String chave = teclado.next();
                        
                        if(servidores.containsKey(chave)){
                            servidores.remove(chave);
                        }else{
                            System.out.println("\nChave inválida!");
                        }
                        
                    }else{
                        System.out.println("Nenhum servidor foi  cadastrado!");
                    }
                    
                    System.out.println("");
                    break;
                case 3:
                    
                    if(servidores.isEmpty()){
                        System.out.println("Nenhum servidor adicionado!\n");
                    }else{
                        for (Map.Entry<String, Servidor> s : servidores.entrySet()) {
                            System.out.println("IP: " + s.getValue().getIp() + " \tLink: " + s.getValue().getLink() + " \tRegião: " + s.getValue().getRegiao() + " \tIdioma: " + s.getValue().getIdioma());
                        }
                        
                        System.out.println("");
                    }
                    
                    break;
            }
        }while(opcao != 4);
        
    }
}
