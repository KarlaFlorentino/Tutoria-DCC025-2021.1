/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercicio07;

import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karla
 */
public class Main {
    public static <T> String print(T entidade) {

        Class<?> clazz = entidade.getClass();

        String retorno = "";
        retorno += clazz.getSimpleName() + ": ";

        while (clazz != null && !clazz.equals(Object.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                try {
                    retorno += f.getName() + " = " + f.get(entidade) + ", ";
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            clazz = clazz.getSuperclass();
        }
        return retorno;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Guerreiro guerreiro = new Guerreiro();

        System.out.println("--- Guerreiro ---");
        System.out.print("Informe a força: ");
        guerreiro.setForca(teclado.nextInt());

        System.out.print("Informe a vida: ");
        guerreiro.setVida(teclado.nextInt());

        System.out.print("Informe a defesa: ");
        guerreiro.setDefesa(teclado.nextInt());

        Curandeiro curandeiro = new Curandeiro();

        System.out.println("\n--- Curandeiro ---");
        System.out.print("Informe a vida: ");
        curandeiro.setVida(teclado.nextInt());

        System.out.print("Informe a defesa: ");
        curandeiro.setDefesa(teclado.nextInt());

        System.out.print("Informe a experiência: ");
        curandeiro.setExperiencia(teclado.nextInt());

        System.out.print("Informe os pontos de energia: ");
        curandeiro.setPontosEnergia(teclado.nextInt());

        System.out.println("");

        System.out.println(print(guerreiro));

        System.out.println(print(curandeiro));

    }
}
