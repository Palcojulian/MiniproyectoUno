package clases;

public class Jugador {

    public double puntos;
    public int inten = 20;
    public Bolsa bolsa;
    public int indice;

    public Jugador() {
        this.bolsa = new Bolsa();
    }
    
    public boolean verTurno(){
        boolean condicionUno = (this.inten>0) ? true:false;
        boolean condicionDos = true;
        
        for (int i = 0; i < bolsa.bolsa.length; i++) {
            condicionDos = (bolsa.bolsa[i] == 0)? true:false;
        }
        
        return condicionUno && condicionDos;
    }
    
    
    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public int getInten() {
        return inten;
    }

    public void setInten(int inten) {
        this.inten = inten;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
