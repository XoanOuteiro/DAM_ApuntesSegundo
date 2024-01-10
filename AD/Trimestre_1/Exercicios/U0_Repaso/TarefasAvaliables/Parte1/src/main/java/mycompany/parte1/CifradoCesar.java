package mycompany.parte1;

/**
 *
 * @author XoanOuteiro
 */
public class CifradoCesar {

    public String cifradoCesar(String cadenaACifrar) {

        StringBuilder cif = new StringBuilder();

        cadenaACifrar = cadenaACifrar.toLowerCase();

        for (int i = 0; i < cadenaACifrar.length(); i++) {

            if (cadenaACifrar.charAt(i) + 3 > 'z') {

                cif.append((char) (cadenaACifrar.charAt(i) + 3 - 26));

            } else {

                cif.append((char) (cadenaACifrar.charAt(i) + 3));

            }

        }

        return cif.toString();

    }

}
