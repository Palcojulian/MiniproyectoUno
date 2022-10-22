package clases;

/**
 * @author palco
 */
public class Bolsa extends HeapSort {
    
    
    public HeapSort[] keysNivelUno;
    
    
    public Bolsa() {
        this.keysNivelUno = new HeapSort[6];
        
    }

    public void setKeysNivelUno(int arreglo[]) {
        for (int i = 1; i < arreglo.length; i++) {
            if (i == 1) {
                this.keysNivelUno[i] = nodo();
                this.keysNivelUno[i].setKeyRaiz(arreglo[i]); //{0,20,12,31,45,10}
                continue;
            }
            
            if (i % 2 == 0) {
                this.keysNivelUno[i] = nodo();
                this.keysNivelUno[i].setKeyRaiz(arreglo[i]);
                this.keysNivelUno[padre(i)].setKeyIzquierda(arreglo[i]);//{0,20,12,31,45,10}
                continue;
            }
            
            if (i % 2 == 1) {
                this.keysNivelUno[i] = nodo();
                this.keysNivelUno[i].setKeyRaiz(arreglo[i]);
                this.keysNivelUno[padre(i)].setKeyDerecha(arreglo[i]);
            }
        }
    }
    
    public HeapSort[] getKeysNivelUno() {
        return keysNivelUno;
    }
    
    public void mostrarBolsaNivelUno(){
        for (int i = 1; i < this.keysNivelUno.length; i++) {
            System.out.println("Nodo" + i);
            System.out.println("Raiz=> "+this.keysNivelUno[i].getKeyRaiz());
            System.out.println("Izquierdo=> "+this.keysNivelUno[i].getKeyIzquierda());
            System.out.println("Derecho=> "+this.keysNivelUno[i].getKeyDerecha());
            
        }
    }

}
