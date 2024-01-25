package mycompany.libreria.API;

import java.util.List;
import org.hibernate.Session;

public class Actuator {

    /*

        ---Atributes

     */
    private Session s;


    /*

        ---Builder Methods

     */
    public Actuator(){};


    /*

        ---Actuator Methods

     */
    public void endSession(){
        
        HibernateUtil.getSessionFactory().close();
        
    }
    
    public void insert(Object obj){

        this.startSession();

        this.s.beginTransaction();
        this.s.save(obj);
        this.s.getTransaction().commit();

    }

    /*

        ---Private methods

     */
    private void startSession(){

        this.s = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();

    }
}
