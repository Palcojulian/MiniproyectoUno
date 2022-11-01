package clases;

/**
 * @author palco
 */
public class Bolsa{ 
    
    public int[] numsRechazados;
    public int bolsa[];
    public HeapSort[] keysNivelUno;
    
    
    public Bolsa() {
        this.bolsa = new int[5];
        this.numsRechazados = new int[40];
        this.keysNivelUno = new HeapSort[6];
        
    }
    
    public void setKeyBolsa(int num, int indice){ //Esta parte se encarga de ingresar un solo elemento a la bolsa
        this.bolsa[indice] = num;
    }

    public int getBolsa(int indice) { //Esta parte se encarga de traer un elemento de la bolsa dea cuerdo al indice 
        return this.bolsa[indice];
    }
    
    public int[] getBolsa() {  
        return bolsa;
    }
    
    public void mostrarBolsa(){
        for (int i = 0; i < bolsa.length; i++) {
            System.out.println("["+this.bolsa[i]+"]");
        }
    }

    public int[] getNumsRechazados() {
        return numsRechazados;
    }

    public void setNumsRechazados(int num, int indice) {
        this.numsRechazados[indice] = num;
    }
    
    
    public HeapSort nodo() {
        HeapSort nodo = new HeapSort();
        return nodo;
    }

    public void setKeysNivelUno(int arreglo[]) {
        
        for (int i = 0; i < arreglo.length; i++) {
            int j = i+1;
            if (j == 1) {
                this.keysNivelUno[j] = nodo();
                this.keysNivelUno[j].setKeyRaiz(arreglo[i]); //{0,20,12,31,45,10}
                continue;
            }
            
            if (j % 2 == 0) {
                this.keysNivelUno[j] = nodo();
                this.keysNivelUno[j].setKeyRaiz(arreglo[i]);
                this.keysNivelUno[j/2].setKeyIzquierda(arreglo[i]);//{0,20,12,31,45,10}
                continue;
            }
            
            if (j % 2 == 1) {
                this.keysNivelUno[j] = nodo();
                this.keysNivelUno[j].setKeyRaiz(arreglo[i]);
                this.keysNivelUno[j/2].setKeyDerecha(arreglo[i]);
            }
        }
    }
    
    
    public HeapSort[] getKeysNivelUno() {
        return keysNivelUno;
    }
    
}
