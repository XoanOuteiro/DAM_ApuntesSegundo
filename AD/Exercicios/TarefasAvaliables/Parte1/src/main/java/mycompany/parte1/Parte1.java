package mycompany.parte1;

/**
 *
 * @author XoanOuteiro
 */
public class Parte1 {

    public static void main(String[] args) {

        //TAREFA 1: CLASE TRABAJADOR
        //Creamos un empleado incorrectamente
        try {

            Trabajador t1 = new Trabajador("Juan", 29, 5, 1);

        } catch (IllegalArgumentException ex) {

            System.out.println(ex.getLocalizedMessage());

        }

        //Creamos un empleado correctamente y mostramos su sueldo
        try {

            Trabajador t1 = new Trabajador("Juan", 29, 2, 1);
            System.out.println("Salario: " + t1.calcularSueldo());

        } catch (IllegalArgumentException ex) {

            System.out.println("Este print no se activará.");

        }

        //----------------------------------------------------------------------
        
        //TAREFA 2: CIFRADO CESAR
        String frase = "Frase a ser cifrada";
        CifradoCesar c = new CifradoCesar();
        System.out.println(c.cifradoCesar(frase));
        
        //----------------------------------------------------------------------
        
        //TAREFA 3: NUMERICOS POR LECTURA DE TECLADO
        SplitNumerico s = new SplitNumerico();
        
        //----------------------------------------------------------------------
        
        //TAREFA 4: CONTROL DE FECHAS
        
        
        //----------------------------------------------------------------------
    }
}
