package pruebas;
import clases.Jugador;
/**
 *
 * @author Paya, Palco, Villa, Rodriguez, Ramos
 */
public class Run {

    public static void main(String[] args) {

        int opcionJugador = Fun.bienvenida();

        if (opcionJugador == 1) {
            Fun.mostrarInstruccionesDelJuego();
        }
        if (opcionJugador == 2) {
            Jugador per = new Jugador();
            Jugador maq = new Jugador();
            int nivel = Fun.mostrarNiveles();
            Fun.mostrarEstadoInicialFinalJugadores(per, maq, nivel, 1);
            int indice = 0;
            int numsRe[] = new int[Fun.rango(nivel) - 10];
            boolean humanTurn = true;

            while (per.verTurno() || maq.verTurno()) {
                if (humanTurn) {
                    if (per.verTurno()) {
                        int num = Fun.generarNumero(per.getBolsa(), maq.getBolsa(), numsRe, nivel);
                        int opcion = Fun.opciones(1, num);
                        if (opcion == 1) {
                            Fun.agregarNumerosBolsaJugador(per, num);
                        }
                        if (opcion == 2) {
                            num = Fun.generarNumero(per.getBolsa(), maq.getBolsa(), numsRe, nivel);
                            opcion = Fun.opciones(2, num);
                            if (opcion == 1) {
                                Fun.agregarNumerosBolsaJugador(per, num);
                            }
                            if (opcion == 2) {
                                numsRe[indice] = num;
                                indice++;
                            }
                        }
                        per.setInten(per.getIntentos() - 1);
                        System.out.println("Estado persona ");
                        Fun.estadoJugador(per);
                    }
                } else {
                    if (maq.verTurno()) {
                        int num = Fun.generarNumero(per.getBolsa(), maq.getBolsa(), numsRe, nivel);
                        if (maq.getIndice() == 0) {
                            Fun.agregarNumerosBolsaJugador(maq, num);
                        } else if (Fun.mejorNumMaquina(maq.getKeyBolsa(0), Fun.rango(nivel), num)) {
                            Fun.agregarNumerosBolsaJugador(maq, num);
                        } else {
                            num = Fun.generarNumero(per.getBolsa(), maq.getBolsa(), numsRe, nivel);
                            if (Fun.mejorNumMaquina(maq.getKeyBolsa(0), Fun.rango(nivel), num)) {
                                Fun.agregarNumerosBolsaJugador(maq, num);
                            } else {
                                numsRe[indice] = num;
                                indice++;
                            }
                        }
                        maq.setInten(maq.getIntentos() - 1);
                        System.out.println("Estado maquina ");
                        Fun.estadoJugador(maq);
                    }
                }
                humanTurn = !humanTurn;
            }
            Fun.mostrarEstadoInicialFinalJugadores(per, maq, nivel, 2);
            Fun.ordenarBolsaDeJugadores(per, maq, nivel);
        }
        if (opcionJugador == 3) {
            Fun.mostrarIntegrantesDelGrupo();
        }
    }
}