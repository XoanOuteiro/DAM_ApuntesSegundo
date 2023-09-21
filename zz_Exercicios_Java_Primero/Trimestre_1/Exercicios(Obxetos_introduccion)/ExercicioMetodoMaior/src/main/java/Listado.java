
/**
 *
 * @author a22xoanmoj
 */
public class Listado {

    //Atribute
    private int[] list;

    //Constructor
    public Listado(int[] list) {
        this.list = list;
    }

    //Getters and Setters
    public int[] getList() {
        return list;
    }

    public void setList(int[] list) {
        this.list = list;
    }

    //Method
    /**
     * O metodo maior: Emprega un bucle for optimizado que percorre os valor
     * enteiros dun array buscando en cada iteracion un valor maior ca o
     * rexistrado -comezando por 0- Devolve o ultimo rexistro, que sera o maior
     * valor do array.
     *
     * Rango: 0 +infinito .
     * Distancia: 1 +infinito .
     *
     * author: @a22xoanmoj
     */
   public int maior() {

        int max = 0;

        for (int j : this.list) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

}
