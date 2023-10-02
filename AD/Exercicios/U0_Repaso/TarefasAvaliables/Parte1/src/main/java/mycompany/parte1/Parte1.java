package mycompany.parte1;

/**
 *
 * @author XoanOuteiro
 */
public class Parte1 {

    public static void main(String[] args) {

        //TAREFA 1: CLASE TRABAJADOR
        //Creamos un empleado incorrectamente
        
        System.out.println(">>Tarefa 1");
        
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

        separate();
        
        //----------------------------------------------------------------------
        
        //TAREFA 2: CIFRADO CESAR
        
        System.out.println(">>Tarefa 2");
        
        String frase = "Frase a ser cifrada";
        CifradoCesar c = new CifradoCesar();
        System.out.println(c.cifradoCesar(frase));
        
        separate();
        
        //----------------------------------------------------------------------
        
        //TAREFA 3: NUMERICOS POR LECTURA DE TECLADO
        
        System.out.println(">>Tarefa 3");
        
        SplitNumerico s = new SplitNumerico();
        
        separate();
        
        //----------------------------------------------------------------------
        
        //TAREFA 4: CONTROL DE FECHAS
        
        System.out.println(">>Tarefa 4");
        
        ControlFechas control = new ControlFechas();
        
        separate();
        
        //----------------------------------------------------------------------
        
        //TAREFA 5: HERENCIA
        
        System.out.println(">>Tarefa 5");
        
        Hora h = new Hora(23,58);
        
        System.out.println(h.toString());
        h.inc();
        System.out.println(h.toString());
        h.inc();
        System.out.println(h.toString());
        
    }
    
    private static void separate(){
        
        for (int i = 0; i < 3; i++) {
            
            System.out.println();
            
        }
        
    }
}
