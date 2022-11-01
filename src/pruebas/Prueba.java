/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import clases.Jugador;

/**
 *
 * @author palco
 */
public class Prueba {

    public static void main(String[] args) {

        int nums[] = {300,12,2,54,1};
        int indices[] = new int[5];
        int numOrdenados[] = new int[5];
        
        for (int i = 0; i < nums.length; i++) {
            int indice = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    indice++;
                }  
            }
            indices[i] = indice;
        }
        
        for (int i = 0; i < indices.length; i++) {
            System.out.println(indices[i]);
        }
        
        for (int i = 0; i < numOrdenados.length; i++) {
            numOrdenados[indices[i]] = nums[i]; 
        }
        
        
        System.out.println("-------------------------");
        for (int i = 0; i < indices.length; i++) {
            System.out.println(numOrdenados[i]);
        }
    }

    public static boolean mejorNum(int numInicial, int rango, int numGenerado) {
        int adelante = generarRango(numInicial, rango);
        int atras = Math.abs(adelante - 10);

        boolean condicionUno = false;
        boolean condicionDos = false;

        for (int i = 1; i <= adelante; i++) {
            if(numGenerado == numInicial+i){
                condicionUno = true;
                i = adelante + 1;
            }
        }

        for (int i = 1; i <= atras; i++) {
            if(numGenerado == numInicial-i){
                condicionUno = true;
                i = atras + 1;
            }
        }

        return condicionUno || condicionDos;
    }

    public static int generarRango(int num, int rango) {

        int rangoAtras = num - 5;
        int rangoAdelante = num + 5;

        int adelante = 0;

        if (rangoAtras == -4) {
            adelante = 10;
        }
        if (rangoAtras == -3) {
            adelante = 9;

        }
        if (rangoAtras == -2) {
            adelante = 8;

        }
        if (rangoAtras == -1) {
            adelante = 7;

        }
        if (rangoAtras == 0) {
            adelante = 6;

        }

        if (rangoAdelante > rango + 5) {
            adelante = 0;
        }

        if (rangoAdelante == rango + 4) {
            adelante = 1;
        }

        if (rangoAdelante == rango + 3) {
            adelante = 2;
        }

        if (rangoAdelante == rango + 2) {
            adelante = 3;
        }

        if (rangoAdelante == rango + 1) {
            adelante = 4;
        }

        if (rangoAdelante == rango) {
            adelante = 5;
        }

        if ((rangoAtras > 0) && (rangoAdelante <= rango)) {
            adelante = 5;
        }

        return adelante;
    }

    public static int genNums(int nivel) {
        int num = (int) (Math.random() * nivel + 1);
        return num;
    }

}