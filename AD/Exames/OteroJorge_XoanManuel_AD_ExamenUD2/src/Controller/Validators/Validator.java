package Validators;

import java.util.InputMismatchException;

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
    /**
     * 
     * Checks that the given parameter consists of 8 digits and 1 alphabetic
     * character
     * 
     * @param nif String
     * @return boolean
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
        if (Character.isAlphabetic(n[8])) { //if the 9th char is a letter

            //System.out.println("NIF VALID");

            return true;

        }

        return false;

    }

    /**
     * 
     * Checks that the given String is of same length or less than
     * the specified int value
     * 
     * @param a String
     * @param l int
     * @return boolean
     */
    public boolean hasLength(String a, int l){

        if(a.length() <= l){

            return true;

        }

        return false;
    }
    
    /**
     * 
     * Checks that a given string is a parsable to float,
     * checks a given regex statement for its format as to know
     * if its compliant to database restrictions and then returns its
     * parsed float value
     * 
     * @param s String
     * @return float
     * @throws InputMismatchException If float is not compliant to regex
     */
    public float parseDataFloat(String s) throws InputMismatchException{
        
        String format = "\\d{1,4}(\\.\\d{2})?";
        float returnable = 0;
        
        if(!(s.matches(format))){
            
            throw new InputMismatchException("String not compliant to: [(0)-(4)][,/.][d2]");
            
        }

            
        returnable = Float.parseFloat(s);   //Parse should not fail as regex checks parseability

        
        return returnable;
        
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
