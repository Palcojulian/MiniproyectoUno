package pruebas;

import clases.Dinamica;
import clases.HeapSort;
import clases.Jugador;
import java.util.Scanner;

/**
 *
 * @author palco
 */
public class Fun {

    public static Scanner input() {
        Scanner in = new Scanner(System.in);
        return in;
    }

    public static int bienvenida() {
        System.out.println("Tower Blaster Modificado");
        System.out.println("1. Ver instrucciones.");
        System.out.println("2. Jugar.");
        System.out.println("3. Creadores.");
        int opcion = input().nextInt();

        while (opcion < 1 || opcion > 3) {
            System.out.println("Incorrecto, ingrese una opción valida");
            opcion = input().nextInt();
        }

        return opcion;
    }

    public static void mostrarInstruccionesDelJuego() {
        System.out.println("Instrucciones del juego... ");
    }

    public static int mostrarNiveles() {
        System.out.println("Tower Blaster Modificado");
        int i = 1;
        while (i < 5) {
            System.out.println(i + ". Nivel " + i);
            i++;
        }
        System.out.println("Ingrese el nivel: ");
        int nivel = input().nextInt();

        while (nivel < 1 || nivel > 4) {
            System.out.println("Incorrecto, ingrese un nivel valido ");
            nivel = input().nextInt();
        }
        return nivel;
    }

    public static void mostrarIntegrantesDelGrupo() {
        System.out.println("Karen Daniela");
        System.out.println("Emily Villa");
        System.out.println("Erika");
        System.out.println("Juan Pablo Perdomo Paya");
        System.out.println("Julian Libardo Palco Guegue");
    }

    public static void agregarNumerosBolsaJugador(Jugador ob, int num) {
        System.out.println("Elegiste el numero -> " + num);
        ob.bolsa.setKeyBolsa(num, ob.getIndice());
        ob.setIndice(ob.getIndice() + 1);
    }

    public static void mostrarEstadoInicialFinalJugardores(Jugador per, Jugador maq, int nivel, int opcion) {

        if (opcion == 1) {

            System.out.println("-------------------------------");
            System.out.println("Nivel: " + nivel);
            System.out.println("Numeros del 1 al " + Fun.rango(nivel));
            System.out.println("-------------------------------");
            System.out.println("Estado inicial de jugadores ");
            System.out.println("Persona");
            Fun.estadoJugador(per);
            System.out.println("Maquina ");
            Fun.estadoJugador(maq);
        }
        if (opcion == 2) {
            System.out.println("Estado final de jugadores");
            System.out.println("Persona ");
            Fun.estadoJugador(per);
            System.out.println("Maquina ");
            Fun.estadoJugador(maq);
        }

    }

    public static void estadoJugador(Jugador ob) {
        System.out.println("Puntos " + ob.getPuntos());
        System.out.println("Intentos " + ob.getInten());
        System.out.println("Bolsa");
        ob.bolsa.mostrarBolsa();
        System.out.println("-------------------------------");
    }

    public static int opciones(int i, int num) {
        System.out.println("Numero -> " + num);
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

        int opcion = input().nextInt();

        return opcion;
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

    public static boolean mejorNum(int numInicial, int rango, int numGenerado) {
        int adelante = generarRango(numInicial, rango);
        int atras = Math.abs(adelante - 10);

        boolean condicionUno = false;
        boolean condicionDos = false;

        for (int i = 1; i <= adelante; i++) {
            if (numGenerado == numInicial + i) {
                condicionUno = true;
                i = adelante + 1;
            }
        }

        for (int i = 1; i <= atras; i++) {
            if (numGenerado == numInicial - i) {
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

    public static void ordenamientoHeapSort(Jugador per, Jugador maq) {
        HeapSort nivelUno = new HeapSort();
        System.out.println("Ordenamiento Nivel 1: HeapSort");
        System.out.println("Persona :3");
        nivelUno.setKeysNivelUno(per.bolsa.getBolsa());
        nivelUno.ordenarNivelUno(nivelUno.getKeysNivelUno());
        System.out.println("Maquina :3");
        nivelUno.setKeysNivelUno(maq.bolsa.getBolsa());
        nivelUno.ordenarNivelUno(nivelUno.getKeysNivelUno());
   
    }

    public static void ordenamientoRadixSort(Jugador per, Jugador maq) {
        System.out.println("En construcción");
    }

    public static void ordenamientoDinamica(Jugador per, Jugador maq) {
        Dinamica nivelTres = new Dinamica();
        System.out.println("Ordenamiento Nivel 3: Programación dinamica");
        System.out.println("Persona");
        nivelTres.ordenarNumeros(per.bolsa.getBolsa());
        System.out.println("Maquina");
        nivelTres.ordenarNumeros(maq.bolsa.getBolsa());
    }

    public static void ordenamientoVoraz(Jugador per, Jugador maq) {
        System.out.println("En construcción");
    }

    public static void ordenarBolsaDeJugadores(Jugador per, Jugador maq, int nivel) {
        if (nivel == 1) {
            Fun.ordenamientoHeapSort(per, maq);
        }
        if (nivel == 2) {
            Fun.ordenamientoRadixSort(per, maq);
        }
        if (nivel == 3) {
            Fun.ordenamientoDinamica(per, maq);
        }
        if (nivel == 4) {
            Fun.ordenamientoVoraz(per, maq);
        }
    }
}
