package clases;

/**
 *
 * @author palco
 */
public class Dinamica{
    private int indices[];
    private int numsOrdenados[];
    
    public Dinamica(){
        this.indices = new int[5];
        this.numsOrdenados = new int[5];
    }
   
    public void frecuenciaMayor(int arreglo[]){
        
        for (int i = 0; i < arreglo.length; i++) {
            int indice = 0;
            for (int j = 0; j < arreglo.length; j++) {
                if(arreglo[i]>arreglo[j]){
                    indice++;
                }
            }
            this.indices[i] = indice;
        }
    }
    
    public void ordenarNumeros(int arreglo[]){
        frecuenciaMayor(arreglo);
        for (int i = 0; i < this.indices.length; i++) {
            this.numsOrdenados[this.indices[i]] = arreglo[i];
        }
        mostrarBolsaNivelTres();
    }
    
    public void mostrarBolsaNivelTres(){
        for (int i = 0; i < this.numsOrdenados.length; i++) {
            System.out.println("["+this.numsOrdenados[i]+"]");
        }
    }   
}
