
package clases;

public class Jugador{
    private int idjugador;
    public double puntos;
    public int intentos = 20;
    public Bolsa bolsa;
    
    
    public Jugador(){
        this.bolsa = new Bolsa();
    }

    public int getIdjugador() {
        return idjugador;
    }

    public void setIdjugador(int idjugador) {
        this.idjugador = idjugador;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public void bolsaJugador(){
        
    }
    
}
