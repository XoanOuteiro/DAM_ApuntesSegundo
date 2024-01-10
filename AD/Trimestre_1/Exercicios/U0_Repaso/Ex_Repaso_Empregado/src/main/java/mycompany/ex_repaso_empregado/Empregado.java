
package mycompany.ex_repaso_empregado;

/**
 *
 * @author XoanOuteiro
 */
public class Empregado {
    
    private String nome;
    private int antiguedade;
    private static int salario_base = 1000;
    private final int PLUS = 10;
    
    public Empregado(String nome, int antiguedade){
        this.nome = nome;
        this.antiguedade = antiguedade;
    }
    
    public static void subirSalario(float perc){
        salario_base += (salario_base * perc)/100;
    }
    
    public void amosarSalario(){
        
        int temp = this.salario_base + (antiguedade*PLUS);
        
        System.out.println("O salario é: " + temp);
    }
}
