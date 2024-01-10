
package mycompany.parte1;

import java.util.Scanner;

/**
 *
 * @author XoanOuteiro
 */
public class SplitNumerico {
    
    private double numero;
    
    public SplitNumerico(){
        Scanner reads = new Scanner(System.in);
        System.out.println("Introduce numero decimal a evaluar: ");
        this.numero = reads.nextDouble();
        
        System.out.println("Parte numerica: " + this.getParteEntera(numero) + " || Parte decimal: " + this.getParteDecimal(numero));
        
    }
    
    public int getParteEntera(double numero){
        
        Double chn = numero;
        String wrd = chn.toString();
        String num = wrd.subSequence(0, wrd.indexOf('.')).toString();
        return Integer.parseInt(num);
        
    }
    
    public int getParteDecimal(double numero){
        
        Double chn = numero;
        String wrd = chn.toString();
        String num = wrd.subSequence(wrd.indexOf('.') +1, wrd.length() ).toString();
        return Integer.parseInt(num);
        
    }
    
}
