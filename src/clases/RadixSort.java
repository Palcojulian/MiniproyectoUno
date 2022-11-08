/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Arrays;

/**
 *
 * @https://the-algorithms.com/es
 */
public class RadixSort {

    private int[] salida;
    private int[] contador;
    private int[] arreglo;

    public RadixSort() {
        this.salida = new int[5];
        this.contador = new int[10];
        this.arreglo = new int[5];
    }

    public int obtMax(int[] arreglo) {
        int mayor = arreglo[0];
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
            }
        }
        return mayor;
    }

    public void contador(int[] arreglo, int tam, int indice) {
        int i;
        Arrays.fill(this.contador, 0);

        for (i = 0; i < tam; i++) {

            this.contador[(arreglo[i] / indice) % 10]++;

        }

        for (i = 1; i < 10; i++) {
            this.contador[i] += this.contador[i - 1];

        }

        for (i = tam - 1; i >= 0; i--) {
            this.salida[this.contador[(arreglo[i] / indice) % 10] - 1] = arreglo[i];

            this.contador[(arreglo[i] / indice) % 10]--;

        }

        for (i = 0; i < tam; i++) {
            this.arreglo[i] = this.salida[i];

//            
        }

    }

    public void ordenarNums(int[] arreglo, int tam) {
        int maximo = obtMax(arreglo);

        for (int indice = 1; maximo / indice > 0; indice *= 10) {

            contador(arreglo, tam, indice);

        }
        mostrarArreglo();
    }

    public void mostrarArreglo() {
        for (int i = 0; i < this.arreglo.length; i++) {
            System.out.println(this.arreglo[i] + " ");
        }
    }

    public static void main(String[] args) {
        RadixSort ob = new RadixSort();
        int nums[] = {2,31,23,41,21};
        ob.ordenarNums(nums, 5);
    }
}
