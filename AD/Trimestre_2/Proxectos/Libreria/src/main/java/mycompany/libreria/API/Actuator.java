package mycompany.libreria.API;

import java.util.ArrayList;
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

    public Autor getAutorByName(String name) {

        try {
            this.startSession();

            String hql = "from Autor where Nombre = :name";

            Query q = this.s.createQuery(hql);
            q.setParameter("name", name);
            Autor res = (Autor) q.uniqueResult();

            return res;
        }catch (Exception ex){

            ex.printStackTrace();

        }

        return null;

    }

    public Libro getLibroByID(int id){

        this.startSession();

        String hql = "from Libro where IdLibro = :id";

        Query q = this.s.createQuery(hql);
        q.setParameter("id", id);
        Libro res = (Libro) q.uniqueResult();

        return res;

    }

    public Libro getLibroByTitle(String title){

        this.startSession();

        String hql = "from Libro where Titulo = :title";

        Query q = this.s.createQuery(hql);
        q.setParameter("title", title);
        Libro res = (Libro) q.uniqueResult();

        return res;


    }

    public ArrayList<Libro> getLibroByAutor(Autor autor){

        try {

            this.startSession();

            String hql = "from Libro where autor = :autor";
            Query query = this.s.createQuery(hql);
            query.setParameter("autor", autor);

            List<Libro> libros = query.list();
            return new ArrayList<>(libros);

        }catch(Exception ex){

            ex.printStackTrace();

        }

        return null;

    }

    public ArrayList<Libro> getLibros(){

        try{

            this.startSession();

            String hql = "from Libro";
            Query query = this.s.createQuery(hql);

            List<Libro> libros = query.list();
            return new ArrayList<>(libros);

        }catch(Exception ex){

            ex.printStackTrace();

        }

        return null;

    }

    public ArrayList<Autor> getAutors(){

        try{

            this.startSession();

            String hql = "from Autor";
            Query query = this.s.createQuery(hql);

            List<Autor> a = query.list();
            return new ArrayList<>(a);

        }catch(Exception ex){

            ex.printStackTrace();

        }

        return null;

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
