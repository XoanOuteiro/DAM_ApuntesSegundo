package mycompany.libreria.API;

import java.util.List;

import mycompany.libreria.Controller_Model.Autor;
import mycompany.libreria.Controller_Model.Libro;
import org.hibernate.Query;
import org.hibernate.Session;

public class Actuator {

    /*

        ---Atributes

     */
    private Session s;
    private final String AUTORES_CLASS = "mycompany.libreria.Controller_Model.Autor";
    private final String LIBROS_CLASS = "mycompany.libreria.Controller_Model.Libro";


    /*

        ---Builder Methods

     */
    public Actuator() {
    }

    ;


    /*

        ---Actuator Methods

     */
    public void endSession() {

        HibernateUtil.getSessionFactory().close();

    }

    public void insert(Object obj) {

        try {
            this.startSession();

            this.s.beginTransaction();
            this.s.save(obj);
            this.s.getTransaction().commit();
            
        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

    public void delete(Object obj){

        try{

            this.startSession();
            this.s.beginTransaction();
            this.s.delete(obj);
            this.s.getTransaction().commit();

        }catch(Exception ex){

            ex.printStackTrace();

        }

    }

    public Autor getAutorByDNI(String dni) {

        this.startSession();
        
        String hql = "from Autor where DniAutor = :dni";

        Query q = this.s.createQuery(hql);
        q.setParameter("dni", dni);
        Autor res = (Autor) q.uniqueResult();

        return res;

    }

    public Libro getLibroByID(int id){

        this.startSession();

        String hql = "from Libro where IdLibro = :id";

        Query q = this.s.createQuery(hql);
        q.setParameter("id", id);
        Libro res = (Libro) q.uniqueResult();

        return res;

    }

    /*

        ---Private methods

     */
    private void startSession() {

        if (this.s == null || !this.s.isOpen()) {
            this.s = HibernateUtil.getSessionAnnotationFactory().openSession();
        }

    }

}
