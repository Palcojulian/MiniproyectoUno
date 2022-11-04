package clases;

/**
 * @author palco
 */
public class Bolsa{ 
    
    public int bolsa[];
    public HeapSort[] keysNivelUno;
    
    public Bolsa() {
        this.bolsa = new int[5];
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
    
}
