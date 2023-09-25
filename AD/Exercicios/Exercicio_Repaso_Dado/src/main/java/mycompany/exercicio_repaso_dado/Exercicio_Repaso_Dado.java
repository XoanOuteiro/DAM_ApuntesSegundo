
package mycompany.exercicio_repaso_dado;

/**
 *
 * @author XoanOuteiro
 */
public class Exercicio_Repaso_Dado {

    public static void main(String[] args) {
        
        Dado d6 = new Dado(6);
        
        for (int i = 0; i < 10; i++) {
            
            System.out.println(d6.diceThrow());
                    
        }
        
    }
}
