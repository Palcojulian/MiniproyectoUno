package clases;

public class Jugador {

    public double puntos;
    public int inten = 20;
    public Bolsa bolsa;
    public int indice;

    public Jugador() {
        this.bolsa = new Bolsa();
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
