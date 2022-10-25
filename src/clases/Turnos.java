package clases;

public class Turnos {

    public static boolean mejorNum(int bolsa[], int num) {
        boolean condicion = false;
        for (int i = 0; i < bolsa.length; i++) {
            if ((num == bolsa[i] - 1) || (num == bolsa[i] + 1)) {
                condicion = true;
            }
        }
        return condicion;
    }

    public static boolean verificarTurnos(int intentos, int bolsa[]) {
        boolean condicionUno = (intentos > 0) ? true : false;                //Operador ternario 
        boolean condicionDos = true;
        
        
        for (int i = 0; i < bolsa.length; i++) {
            condicionDos = (bolsa[i] == 0) ? true : false;                   //Operador ternario
        }
        
        return condicionUno && condicionDos;
    }

    public static int rango(int nivel) {
        if (nivel == 1) {
            return 5;
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

    public static int generarNums(int nivel) {
        int num = (int) (Math.random() * nivel + 1);
        return num;
    }
    
    public static boolean verificarNums(int bolsa[], int num) { 
        boolean condicion = true;
        for (int i = 0; i < bolsa.length; i++) {
            if (bolsa[i] == num) { 
                condicion = false;
                i = bolsa.length;
            }
        }
        return condicion;
    }
    
    public static void main(String[] args) {
        int nums[] = new int[5];
        int numsDos[] = new int[5];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = generarNums(rango(1));
            System.out.println(nums[i]);
        }
        System.out.println("---------------------");
        
        int condicion = 0;
        while(condicion<5){
            int num = generarNums(rango(1));
            if(verificarNums(numsDos, num)){
                numsDos[condicion] = num;
                System.out.println(numsDos[condicion]);
                condicion++;
            }
        }
    }
}

/*
    

*/
