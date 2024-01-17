/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hibernatemaven;

import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author a22danielpc
 */
public class HibernateMaven {

    public static void main(String[] args) {
       actor act1 = new actor();
		act1.setFirst_name("Romeo");
		act1.setLast_name("Julieta");
		act1.setLast_update(new Date());
		
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(act1);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Actor ID="+act1.getActor_id());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
    }
}
