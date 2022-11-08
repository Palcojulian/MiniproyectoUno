package clases;

/**
 * @author Paya, Palco, Villa, Rodriguez, Ramos
 */
public class HeapSort extends Bolsa{

    private int keyIzquierda;
    private int keyDerecha;
    private int keyRaiz;
    
    private HeapSort nodo() {
        HeapSort nodo = new HeapSort();
        return nodo;
    }
    
    public void setKeysNivelUno(int arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            int j = i+1;
            if (j == 1) {
                this.keysNivelUno[j] = nodo();
                this.keysNivelUno[j].setKeyRaiz(arreglo[i]);
                continue;
            }
            
            if (j % 2 == 0) {
                this.keysNivelUno[j] = nodo();
                this.keysNivelUno[j].setKeyRaiz(arreglo[i]);
                this.keysNivelUno[padre(j)].setKeyIzquierda(arreglo[i]);
                continue;
            }
            
            if (j % 2 == 1) {
                this.keysNivelUno[j] = nodo();
                this.keysNivelUno[j].setKeyRaiz(arreglo[i]);
                this.keysNivelUno[padre(j)].setKeyDerecha(arreglo[i]);
            }
        }
    }
    
    public HeapSort[] getKeysNivelUno() {
        return keysNivelUno;
    }
    
    private void buildHeap(HeapSort keys[], int indice) { 
        int auxiliar;
        for (int i = indice; i > 1; i--) {
            
            if ((keys[i].getKeyRaiz() > keys[padre(i)].getKeyRaiz())) {
                auxiliar = keys[i].getKeyRaiz();
                keys[i].setKeyRaiz(keys[padre(i)].getKeyRaiz());
                keys[padre(i)].setKeyRaiz(auxiliar);
                if (i % 2 == 0) {
                    keys[padre(i)].setKeyIzquierda(keys[i].getKeyRaiz());
                }
                if (i % 2 == 1) {
                    keys[padre(i)].setKeyDerecha(keys[i].getKeyRaiz());
                }
            }
            
            if(keys[i].getKeyRaiz()<keys[i].getKeyIzquierda()){
                buildHeap(keys,(i*2));
            }
            
            if(keys[i].getKeyRaiz()<keys[i].getKeyDerecha()){
                buildHeap(keys,(i*2)+1);
            }            
        }
    }
    
    
    private void heapSort(HeapSort keys[], int indice) {
        int auxiliar;
        auxiliar = keys[1].getKeyRaiz();
        keys[1].setKeyRaiz(keys[indice].getKeyRaiz());
        keys[indice].setKeyRaiz(auxiliar);
        
        if(indice%2==0){
            keys[padre(indice)].setKeyIzquierda(0);
        }else{
            keys[padre(indice)].setKeyDerecha(0);
        }
        
    }
    
    public void ordenarNivelUno(HeapSort keys[]){
        int i = 5;
        while(i>1){
            buildHeap(keys, i);
            heapSort(keys, i);
            i--;
        }
        mostrarBolsaNivelUno();
    }
    
    private void mostrarBolsaNivelUno(){
        for (int i = 1; i < this.keysNivelUno.length; i++) {
            System.out.println("["+this.keysNivelUno[i].getKeyRaiz()+"]");
        }
    }
    
    public static int padre(int padre){
        return padre/2;
    }

    public int getKeyIzquierda() {
        return keyIzquierda;
    }

    public void setKeyIzquierda(int keyIzquierda) {
        this.keyIzquierda = keyIzquierda;
    }

    public int getKeyDerecha() {
        return keyDerecha;
    }

    public void setKeyDerecha(int keyDerecha) {
        this.keyDerecha = keyDerecha;
    }

    public int getKeyRaiz() {
        return keyRaiz;
    }

    public void setKeyRaiz(int keyRaiz) {
        this.keyRaiz = keyRaiz;
    }
    
   
}