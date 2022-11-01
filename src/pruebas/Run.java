package pruebas;
import clases.Jugador;

/**
 *
 * @author palco
 */
public class Run {

    public static void main(String[] args) {
        Jugador per = new Jugador();
        Jugador maq = new Jugador();

        int nivel = Fun.mostrarNiveles();

        while (nivel < 1 || nivel > 4) {
            System.out.println("Incorrecto, ingrese un nivel valido ");
            nivel = Fun.input().nextInt();
        }

        Fun.mostrarEstadoInicialJugardores(per, maq, nivel);

        int indice = 0;
        int numsRe[] = new int[Fun.rango(nivel) - 10];
        boolean humanTurn = true;

        while (Fun.turno(per.getInten(), per.bolsa.getBolsa()) || Fun.turno(maq.getInten(), maq.bolsa.getBolsa())) {
            if (humanTurn) {
                if (per.getIndice() <= 4) {
                    int num = Fun.generarNumero(per.bolsa.getBolsa(), maq.bolsa.getBolsa(), numsRe, nivel);
                    System.out.println("Numero -> " + num);
                    int opcion = Fun.opciones(1);

                    if (opcion == 1) {
                        per.bolsa.setKeyBolsa(num, per.getIndice());
                        per.setIndice(per.getIndice() + 1);
                    }
                    if (opcion == 2) {
                        num = Fun.generarNumero(per.bolsa.getBolsa(), maq.bolsa.getBolsa(), numsRe, nivel);
                        System.out.println("Nuevo numero -> " + num);
                        opcion = Fun.opciones(2);

                        if (opcion == 1) {
                            per.bolsa.setKeyBolsa(num, per.getIndice());
                            per.setIndice(per.getIndice() + 1);
                        }

                        if (opcion == 2) {
                            System.out.println("Saltaste el turno");
                            numsRe[indice] = num;
                            indice++;
                        }
                    }
                    per.setInten(per.getInten() - 1);
                    System.out.println("Estado persona ");
                    Fun.estadoJugador(per);
                }

            } else {

                if (maq.getIndice() <= 4) {
                    int num = Fun.generarNumero(per.bolsa.getBolsa(), maq.bolsa.getBolsa(), numsRe, nivel);

                    if (maq.getIndice() == 0) {
                        System.out.println("Primer numero de la bolsa-> " + num);
                        maq.bolsa.setKeyBolsa(num, maq.getIndice());
                        maq.setIndice(maq.getIndice() + 1);
                    }

                    if (Fun.mejorNum(maq.bolsa.getBolsa(0), Fun.rango(nivel), num)) {
                        maq.bolsa.setKeyBolsa(num, maq.getIndice());
                        maq.setIndice(maq.getIndice() + 1);
                    } else {
                        num = Fun.generarNumero(per.bolsa.getBolsa(), maq.bolsa.getBolsa(), numsRe, nivel);
                        if (Fun.mejorNum(maq.bolsa.getBolsa(0), Fun.rango(nivel), num)) {
                            maq.bolsa.setKeyBolsa(num, maq.getIndice());
                            maq.setIndice(maq.getIndice() + 1);
                        } else {
                            numsRe[indice] = num;
                            indice++;
                        }
                    }

                    maq.setInten(maq.getInten() - 1);

                    System.out.println("Estado maquina ");
                    Fun.estadoJugador(maq);
                }
            }
            humanTurn = !humanTurn;
        }

        System.out.println("Bolsa final persona: ");
        Fun.estadoJugador(per);
        System.out.println("Bolsa final maquina: ");
        Fun.estadoJugador(maq);

        if (nivel == 1) {
            Fun.ordenamientoHeapSort(per, maq);
        }
        if (nivel == 2) {
            System.out.println("Ordenamiento Nivel 2: RadixSort");
            System.out.println("En construcción...");
        }
        if (nivel == 3) {
            System.out.println("Ordenamiento Nivel 3: Programación Dinamica");
            System.out.println("En construcción...");
        }
        if (nivel == 4) {
            System.out.println("Ordenamiento Nivel 4: Programación Voraz");
            System.out.println("En construcción...");
        }
        
        System.out.println("------------------------------");

        for (int i = 0; i < numsRe.length; i++) {
            System.out.println("[" + numsRe[i] + "]");
        }

    }
    
}
