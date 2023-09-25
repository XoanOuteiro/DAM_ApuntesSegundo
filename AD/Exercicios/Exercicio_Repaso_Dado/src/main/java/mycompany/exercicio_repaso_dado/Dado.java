
package mycompany.exercicio_repaso_dado;

import java.util.Random;

/**
 *
 * @author XoanOuteiro
 */
public class Dado {
    
    int min = 1;
    int max;
    Random rng = new Random();
    
    public Dado(int d){
        this.max = d;
    }
    
    public int diceThrow(){
        return rng.nextInt(max)+min;
    }
    
}
