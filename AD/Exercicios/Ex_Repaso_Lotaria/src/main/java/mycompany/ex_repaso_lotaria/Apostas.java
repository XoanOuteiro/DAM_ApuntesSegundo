
package mycompany.ex_repaso_lotaria;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author XoanOuteiro
 */
public class Apostas {
    
    private int[] values = new int[6];
    private int maxval = 49;
    private int minval = 1;
    
    private int reintegro_max = 9;
    private int reintegro;
    private Random rng = new Random();
    
    public Apostas(){
        
        for(int i = 0; i<values.length; i++){
            
            values[i] = rng.nextInt(maxval)+minval;
            
        }
        
        this.reintegro = rng.nextInt(9)+0;
        
        
        this.amosar();
    }
    
    private void amosar(){
        
        System.out.println(Arrays.toString(values));
        System.out.println("Reintegro: " + reintegro);
        
    }
    
}
