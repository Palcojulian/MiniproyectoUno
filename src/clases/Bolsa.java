package clases;

/**
 * @author palco
 */
public class Bolsa{ 
  
    public HeapSort[] keysNivelUno;
    public Voraz[] keysNivelCuatro;
    
    public Bolsa() {
        this.keysNivelUno = new HeapSort[6];
        this.keysNivelCuatro = new Voraz[5];
    }
    
   

    // AlgoritmoVoraz
    public static void setNivelCuatro(int vector[]) {

        // DefiniciÃ³n del arreglo inicial
        System.out.print("Vector inicial\n");

        // llamar metodo para mostrar arreglo
        mostrarVector(vector);

        // Detectar el dato menor del arreglo
        int nodoPartida = 30; // Limite de nÃºmero del nodo
        for (int i = 0; i < vector.length; i++) { // itera hasta 5 tamaÃ±o del vector

            // dato menor
            // valor posicion 0 es menor a nodo de partida 30
            if (vector[i] < nodoPartida) {
                nodoPartida = vector[i];
            }
        }

        
        System.out.println("Nodo de partida: " + nodoPartida);

        // DefiniciÃ³n de arreglo donde guardaremos los nodos visitado
        int[] visitado = new int[5];
        visitado[0] = nodoPartida;

        System.out.println("\nSolucion:\n");

        // Solucion
        // se ejecuta 4 veces porque ya tiene un valor en visitado
        for (int j = 1; j < visitado.length; j++) {
            // Guardaremos el numero mayor del arreglo de los nodos visitado
            int nodoVisitado = 0;
            for (int i = 0; i < visitado.length; i++) {
                if (visitado[i] > nodoVisitado) {
                    nodoVisitado = visitado[i];
                }
            }
            System.out.println("Ãšltimo nodo visitado: " + nodoVisitado);

            // Analisis
            int nodoSiguiente = 0; // nodo siguinte al visitado
            int distancia = 100;

            for (int i = 0; i < vector.length; i++) {
                if (vector[i] > nodoVisitado) {
                    int suma = vector[i] + nodoVisitado;
                    // System.out.print(suma + " - ");

                    // menor suma
                    if (suma < distancia) {
                        distancia = suma;
                        nodoSiguiente = distancia - nodoVisitado; // restar a la suma el nodo visitado para saber el
                        // valor del nodo
                    }
                }
            }
            
            System.out.println("nodo Visitado " + nodoVisitado);
            System.out.println("Nodo siguiente: " + nodoSiguiente);

            // Guardo el nodo que seguia en los nodos visitado
            visitado[j] = nodoSiguiente;
            mostrarVector(visitado);

            System.out.println("-----------");

        }

    }
    // Metodo para mostrar el arreglo
    public static void mostrarVector(int vector[]) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print("[" + vector[i] + "] ");
        }
        System.out.print("\n");
    }
    
    public static void main(String[] args) {
        int nums[] = {20,18,29,2,30};
        setNivelCuatro(nums);
    }
}
