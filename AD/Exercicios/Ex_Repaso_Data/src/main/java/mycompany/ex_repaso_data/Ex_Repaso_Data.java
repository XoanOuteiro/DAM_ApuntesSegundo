

package mycompany.ex_repaso_data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author XoanOuteiro
 */
public class Ex_Repaso_Data {

    public static void main(String[] args) {
        Date data = new Date();
        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(data));
    }
}
