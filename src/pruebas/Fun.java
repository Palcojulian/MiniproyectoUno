package pruebas;

import clases.Dinamica;
import clases.HeapSort;
import clases.Jugador;
import clases.RadixSort;
import clases.Voraz;
import java.util.Scanner;

/**
 *
 * @author Paya, Palco, Villa, Rodriguez, Ramos
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
        System.out.println("Karen Daniela Rodriguez - 201961037");
        System.out.println("Emily Alexandra Villa - 201961306");
        System.out.println("Erika Lorena Ramos Findo - 201965704");
        System.out.println("Juan Pablo Perdomo Paya - 201961422");
        System.out.println("Julian Libardo Palco Guegue - 201961045");
    }

    public static void mostrarEstadoInicialFinalJugadores(Jugador per, Jugador maq, int nivel, int opcion) {

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
        System.out.println("Intentos " + ob.getIntentos());
        System.out.println("Bolsa");
        ob.mostrarBolsa();
        System.out.println("-------------------------------");
    }

    public static int opciones(int i, int num) {
        System.out.println("Numero -> " + num);
        System.out.println("¡¡ Que desea Hacer !!");
        if (i == 1) {
            System.out.println("1. Elegir numero.");
            System.out.println("2. Generar otro numero.");
        }

        if (i == 2) {
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

    /*
      Esta funcion genera un numero de manera aleatoria, el numero esta dentro-
      del rango que tome, num>0<=rango.
     */
    public static int numsAleatorios(int rango) {
        int num = (int) (Math.random() * rango + 1);
        return num;
    }

    /*
        Nos permite verficar si el numero que genera de manera aleatoria no-
        esta repetida dentro de los numeros que hay en la bolsa de los-
        jugadores y la bolsa donde van los numeros rechazados.
     */
    public static boolean numeroRepetido(int bolsaUno[], int bolsaDos[], int bolsaTres[], int num) {
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

        boolean condicion = numeroRepetido(bolsaUno, bolsaDos, bolsaTres, num);

        while (condicion) {
            num = numsAleatorios(rango(nivel));
            condicion = numeroRepetido(bolsaUno, bolsaDos, bolsaTres, num);
        }

        return num;
    }

    public static boolean mejorNumMaquina(int numInicial, int rango, int numGenerado) {
        int sucesores = generarRango(numInicial, rango);
        int antecesores = Math.abs(sucesores - 10);
        boolean condicionUno = false;
        boolean condicionDos = false;
        for (int i = 1; i <= sucesores; i++) {
            if (numGenerado == numInicial + i) {
                condicionUno = true;
                i = sucesores + 1;
            }
        }
        for (int i = 1; i <= antecesores; i++) {
            if (numGenerado == numInicial - i) {
                condicionUno = true;
                i = antecesores + 1;
            }
        }
        return condicionUno || condicionDos;
    }

    public static int generarRango(int num, int rango) {
        int antecesor = num - 5;
        int sucesor = num + 5;
        int sucesores = 0;

        sucesores = (antecesor == -4) ? 10 : 0;

        sucesores = (antecesor == -3) ? 9 : 0;

        sucesores = (antecesor == -2) ? 8 : 0;

        sucesores = (antecesor == -1) ? 7 : 0;

        sucesores = (antecesor == 0) ? 6 : 0;

        sucesores = (sucesor == rango + 5) ? 0 : 0;

        sucesores = (sucesor == rango + 4) ? 1 : 0;

        sucesores = (sucesor == rango + 3) ? 2 : 0;

        sucesores = (sucesor == rango + 2) ? 3 : 0;

        sucesores = (sucesor == rango + 1) ? 4 : 0;

        if ((antecesor > 0) && (sucesor <= rango)) {
            sucesores = 5;
        }
        return sucesores;
    }

    public static void agregarNumerosBolsaJugador(Jugador ob, int num) {
        System.out.println("Elegiste el numero -> " + num);
        ob.setKeyBolsa(num);
        ob.setIndice(ob.getIndice() + 1);
    }

    public static void ordenamientoHeapSort(Jugador per, Jugador maq) {
        HeapSort nivelUno = new HeapSort();
        System.out.println("Ordenamiento Nivel 1: HeapSort");
        System.out.println("Persona :3");
        nivelUno.setKeysNivelUno(per.getBolsa());
        nivelUno.ordenarNivelUno(nivelUno.getKeysNivelUno());
        System.out.println("Maquina :3");
        nivelUno.setKeysNivelUno(maq.getBolsa());
        nivelUno.ordenarNivelUno(nivelUno.getKeysNivelUno());
    }

    public static void ordenamientoRadixSort(Jugador per, Jugador maq) {
        System.out.println("Ordenamiento Nivel 2: RadixSort");
        System.out.println("Tuvimos bugs con el codigo F :c ");
    }

    public static void ordenamientoDinamica(Jugador per, Jugador maq) {
        Dinamica nivelTres = new Dinamica();
        System.out.println("Ordenamiento Nivel 3: Programación dinamica");
        System.out.println("Persona");
        nivelTres.ordenarNumeros(per.getBolsa());
        System.out.println("Maquina");
        nivelTres.ordenarNumeros(maq.getBolsa());
    }

    public static void ordenamientoVoraz(Jugador per, Jugador maq) {
        Voraz orPer = new Voraz();
        System.out.println("Ordenamiento nivel 4: programación Voraz");
        System.out.println("Persona");
        orPer.buscarDistaciaEntreNodos(per.getBolsa());
      
        Voraz orMaq = new Voraz();
        System.out.println("Maquina");
        orMaq.buscarDistaciaEntreNodos(maq.getBolsa());
        
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
