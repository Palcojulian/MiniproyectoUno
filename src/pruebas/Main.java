package pruebas;

/**
 * @author palco
 */
import clases.Bolsa;
import clases.Jugador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Jugador per = new Jugador();
        Jugador maq = new Jugador();

        int nivel = bienvenida();
        while (nivel < 1 || nivel > 4) {
            System.out.println("Incorrecto, ingrese un nivel valido ");
            nivel = input().nextInt();
        }

        System.out.println("Nivel: " + nivel);
        System.out.println("Numeros del 1 al " + rango(nivel));

        System.out.println("-------------------------------");
        System.out.println("Estado persona ");
        estadoJugador(per);
        System.out.println("Estado maquina ");
        estadoJugador(maq);

        int numsRe[] = new int[rango(nivel) - 10];
        boolean humanTurn = true;
        int numSaltado = 0;

        while (turno(per.getInten(), per.bolsa.getBolsa()) || turno(maq.getInten(), maq.bolsa.getBolsa())) {

            if (humanTurn) {
                if (per.getIndice() <= 4) {
                    int num = generarNumero(per.bolsa.getBolsa(), maq.bolsa.getBolsa(), numsRe, nivel);
                    System.out.println("Numero -> " + num);
                    int opcion = opciones(1);

                    if (opcion == 1) {
                        per.bolsa.setKeyBolsa(num, per.getIndice());
                        per.setIndice(per.getIndice() + 1);
                    }
                    if (opcion == 2) {
                        num = generarNumero(per.bolsa.getBolsa(), maq.bolsa.getBolsa(), numsRe, nivel);
                        System.out.println("Nuevo numero -> " + num);

                        opcion = opciones(2);
                        if (opcion == 1) {
                            per.bolsa.setKeyBolsa(num, per.getIndice());
                            per.setIndice(per.getIndice() + 1);
                        }

                        if (opcion == 2) {
                            System.out.println("Saltaste el turno");
                            numSaltado = num;
                        }
                    }

                    per.setInten(per.getInten() - 1);
                    System.out.println("Estado persona ");
                    estadoJugador(per);
                }
                
            } else {
                if (maq.getIndice() <= 4) {
                    int num = generarNumero(per.bolsa.getBolsa(), maq.bolsa.getBolsa(), numsRe, nivel);
                    System.out.println("Numero -> " + num);
                    maq.bolsa.setKeyBolsa(num, maq.getIndice());
                    maq.setIndice(maq.getIndice() + 1);
                    maq.setInten(maq.getInten() - 1);
                    System.out.println("Estado maquina ");
                    estadoJugador(maq);
                }
            }
            humanTurn = !humanTurn;
        }

        System.out.println("Bolsa final persona: ");
        estadoJugador(per);
        System.out.println("Bolsa final maquina: ");
        estadoJugador(maq);

    }

    public static Scanner input() {
        Scanner in = new Scanner(System.in);
        return in;
    }

    public static int bienvenida() {
        System.out.println("Tower Blaster Modificado");
        int i = 1;
        while (i < 5) {
            System.out.println(i + ". Nivel " + i);
            i++;
        }
        System.out.println("Ingrese el nivel: ");
        int nivel = input().nextInt();

        return nivel;
    }

    public static void estadoJugador(Jugador ob) {
        System.out.println("Puntos " + ob.getPuntos());
        System.out.println("Intentos " + ob.getInten());
        System.out.println("Bolsa");
        ob.bolsa.mostrarBolsa();
        System.out.println("-------------------------------");
    }

    public static int opciones(int i) {
        if (i == 1) {
            System.out.println("¡¡ Que desea Hacer !!");
            System.out.println("1. Elegir numero.");
            System.out.println("2. Generar otro numero.");
        }

        if (i == 2) {
            System.out.println("¡¡ Que desea Hacer !!");
            System.out.println("1. Elegir numero.");
            System.out.println("2. Saltar Turno.");
        }

        int num = input().nextInt();

        return num;
    }

    public static int rango(int i) {
        if (i == 1) {
            return 50;
        }
        if (i == 2) {
            return 45;
        }
        if (i == 3) {
            return 40;
        }
        if (i == 4) {
            return 30;
        }
        return 0;
    }

    public static boolean numConse(int bolsa[], int num) {
        boolean condicion = false;
        for (int i = 0; i < bolsa.length; i++) {

            if ((num == bolsa[i] - 1) || (num == bolsa[i] + 1)) {
                condicion = true;
            }
        }
        return condicion;
    }

    public static boolean turno(int intentos, int bolsa[]) {
        boolean condicionUno = (intentos > 0) ? true : false;                //Operador ternario 
        boolean condicionDos = true;

        for (int i = 0; i < bolsa.length; i++) {
            condicionDos = (bolsa[i] == 0) ? true : false;                   //Operador ternario
        }

        return condicionUno && condicionDos;
    }

    public static int numsAleatorios(int rango) {
        int num = (int) (Math.random() * rango + 1);
        return num;
    }

    public static boolean verificarNumero(int bolsaUno[], int bolsaDos[], int bolsaTres[], int num) {

        boolean condicionUno = false;
        boolean condicionDos = false;
        boolean condicionTres = false;

        for (int i = 0; i < bolsaUno.length; i++) {
            if (num == bolsaUno[i]) {
                condicionUno = true;
                i = bolsaUno.length;
            }
        }

        for (int i = 0; i < bolsaDos.length; i++) {
            if (num == bolsaDos[i]) {
                condicionDos = true;
                i = bolsaDos.length;
            }
        }

        for (int i = 0; i < bolsaTres.length; i++) {
            if (num == bolsaTres[i]) {
                condicionTres = true;
                i = bolsaTres.length;
            }
        }

        return condicionUno || condicionDos || condicionTres;
    }

    public static int generarNumero(int bolsaUno[], int bolsaDos[], int bolsaTres[], int nivel) {
        int num = numsAleatorios(rango(nivel));
        boolean condicion = verificarNumero(bolsaUno, bolsaDos, bolsaTres, num);
        while (condicion) {
            num = numsAleatorios(rango(nivel));
            condicion = verificarNumero(bolsaUno, bolsaDos, bolsaTres, num);
        }
        return num;
    }

}
