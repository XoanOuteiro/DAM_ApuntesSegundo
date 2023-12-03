package Validators;

/**
 *
 * A class containing various utility checkers
 * to simplify controller classes
 *
 * @author XoanOuteiro
 *
 */
public class Validator {

    public Validator(){

    }

    /*

        --Utility methods--

     */
    public boolean checkNif(String nif) {

        char[] numValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] n = nif.toCharArray();

        for (int i = 0 ; i < n.length-1; i++) {


            if (!(this.in(n[i], numValues))) {

                return false; //One of the values isn't a number

            }

        }

        //System.out.println("Exited for loop on nif check");
        if (!(this.in(n[8], numValues))) { //if the 9th char is a letter

            //System.out.println("NIF VALID");

            return true;

        }

        return false;

    }

    public boolean hasLength(String a, int l){

        if(a.length() <= l){

            return true;

        }

        return false;
    }


    /*

        --Private methods--

     */
    private boolean in(char c, char[] values) {

        for (char check : values) {

            if (check == c) {

                return true;

            }

        }

        return false;

    }
}
