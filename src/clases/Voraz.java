package clases;

/**
 *
 * @author Paya, Palco, Villa, Rodriguez, Ramos
 */
public class Voraz {

    private int visitados[];
    private int nodoPartida;

    public Voraz() {
        this.visitados = new int[5];
    }

    private void buscarNodoDepartida(int arreglo[]) {
        this.nodoPartida = 30;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] < this.nodoPartida) {
                this.nodoPartida = arreglo[i];
            }
        }
        this.visitados[0] = this.nodoPartida;
    }

    public void buscarDistaciaEntreNodos(int arreglo[]) {
        buscarNodoDepartida(arreglo);
        for (int i = 1; i < this.visitados.length; i++) {
            int nodoVisitado = 0;
            for (int j = 0; j < this.visitados.length; j++) {
                if (this.visitados[j] > nodoVisitado) {
                    nodoVisitado = this.visitados[j];
                }
            }
            int nodoSiguiente = 0;
            int distancia = 100;
            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[j] > nodoVisitado) {
                    int suma = arreglo[j] + nodoVisitado;

                    if (suma < distancia) {
                        distancia = suma;
                        nodoSiguiente = distancia - nodoVisitado;
                    }
                }
            }
            this.visitados[i] = nodoSiguiente;
        }
        mostrarKeysNivelCuatro();
    }

    public void mostrarKeysNivelCuatro() {
        for (int i = 0; i < this.visitados.length; i++) {
            System.out.println("[" + this.visitados[i] + "]");
        }
    }

    public int getNodoPartida() {
        return nodoPartida;
    }

    public void setNodoPartida(int nodoPartida) {
        this.nodoPartida = nodoPartida;
    }
}
