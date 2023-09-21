/**
 *
 * @author a22xoanmoj
 */
import java.util.Arrays;
import java.util.Scanner;

public class ExercicioMetodoMaior {

    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Introduza 10 numeros enteiros a considerar: ");
        int[] listed = {reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt(), reader.nextInt()};
        Listado lista1 = new Listado(listed);
        
        System.out.println("A sua lista é " + Arrays.toString(lista1.getList()));
        System.out.println("O maior valor é " + lista1.maior());
    }
}
