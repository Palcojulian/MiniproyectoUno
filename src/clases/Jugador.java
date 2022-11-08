package clases;

//@author Paya, Palco, Villa, Rodriguez, Ramos

public class Jugador {

    private double puntos;
    private int intentos = 20;
    private int indice;
    private int bolsa[];
    

    public Jugador() {
        this.bolsa = new int[5];
    }
    
    public boolean verTurno(){
        boolean condicionUno = (this.intentos>0) ? true:false;
        boolean condicionDos = true;
        for (int i = 0; i < this.bolsa.length; i++) {
            condicionDos = (this.bolsa[i] == 0)? true:false;
        }
        return condicionUno && condicionDos;
    }
    
    public int getKeyBolsa(int num) {
        return this.bolsa[num];
    }
    
    public int[] getBolsa() {
        return bolsa;
    }

    public void setKeyBolsa(int num) {
        this.bolsa[this.indice] = num;
    }
    
    public void  mostrarBolsa(){
        for (int i = 0; i < this.bolsa.length; i++) {
            System.out.println("["+this.bolsa[i]+"]");
        }
    }
    
    public int getIndice() {
        return indice;
    }
    
    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public int getIntentos() {
        return intentos;
    }

    public void setInten(int inten) {
        this.intentos = inten;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
