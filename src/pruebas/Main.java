package pruebas;

/**
 * @author palco
 */
import clases.Jugador;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        int nums[] = {0, 20, 12, 31, 45, 10};
        Jugador persona = new Jugador();
        
        
        persona.bolsa.setKeysNivelUno(nums);
        persona.bolsa.mostrarBolsaNivelUno();
        System.out.println("----------------------------");
        persona.bolsa.ordenarNivelUno(persona.bolsa.getKeysNivelUno());
        persona.bolsa.mostrarBolsaNivelUno();
        
        
        
        
//        int nums[] = {0,20,12,13,14,40};
//        String dividir[] = new String[nums.length];
//        
//        for (int i = 1; i < nums.length; i++) {
//            dividir[i] = nums[i]+"";
//            System.out.println(dividir[i]);
//        }
//        
//       
//        
//        Scanner in = new Scanner(System.in);
//        int nums[] = new int[6];
//        Jugador persona = new Jugador();
//        int i = 1;
//        while (i < 6) {
//            System.out.println("Ingrese un numero");
//            int num = in.nextInt();
//            nums[i] = num;
//            persona.bolsa.setKeysNivelUno(nums);
//            persona.bolsa.mostrarBolsaNivelUno();
//            i++;
//        }
//        persona.bolsa.ordenarNivelUno(persona.bolsa.getKeysNivelUno());
//        System.out.println("Bolsa ordenada");
//        persona.bolsa.mostrarBolsaNivelUno();
    }
}
