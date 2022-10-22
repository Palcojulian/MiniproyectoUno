package clases;
/**
 * @author palco
 */

//Clase nivel por ahora esta pensada para dar el rango de numeros a elegir dependiendo del nivel.

public class Nivel {

    public int nivel;
    
    public Nivel(int nivel){
        this.nivel = nivel;
    }
    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int rango(int nivel){
        if (nivel == 1) {
            return 50;
        } 
        if (nivel == 2) {
            return 45;
        } 
        if (nivel == 3) {
            return 40;
        }
        if (nivel == 4) {
            return 30;
        } 
        return 0;
    }
}
