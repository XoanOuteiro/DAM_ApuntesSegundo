
/**
 *
 * @author a22xoanmoj
 */
public class ExercicioPinoObxeto {

    public static void main(String[] args) {
        Pino pino1 = new Pino(40);
        pino1.setAltura(30);    //Demostro o setter cambiando a altura
        pino1.Cortar(20);
        System.out.println("O pino foi cortado e agora ten de altura: " + pino1.getAltura() );
    }
}
