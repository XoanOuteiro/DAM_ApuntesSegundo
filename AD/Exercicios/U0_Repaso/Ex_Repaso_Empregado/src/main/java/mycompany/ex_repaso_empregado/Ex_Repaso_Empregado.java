

package mycompany.ex_repaso_empregado;

/**
 *
 * @author XoanOuteiro
 */
public class Ex_Repaso_Empregado {

    public static void main(String[] args) {
        Empregado a = new Empregado("Marcos",10);
        Empregado b = new Empregado("Carlos",13);
        
        b.amosarSalario();
        a.amosarSalario();
        
        Empregado.subirSalario(15);
        
        b.amosarSalario();
        a.amosarSalario();
        
    }
}
