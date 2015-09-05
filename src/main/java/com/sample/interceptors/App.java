/**
 * @autor pathmasri
 * May 25, 2015 11:32:48 PM
 */
package com.sample.interceptors;


import org.hibernate.Query;
import org.hibernate.Session;


public class App 
{
    public static void main( String[] args ) {

        Session session = HibernateUtil.getSessionFactory().openSession();

       //test insert
        System.out.println("*** Test insert ***");

        session.beginTransaction();
        Student student = new Student();

        student.setName("JavaFun");
        student.setAge(19);

        session.saveOrUpdate(student);
        session.getTransaction().commit();

      //test update
        System.out.println("*** Test Update ***");

        session.beginTransaction();
        Query query = session.createQuery("from Student where age = 19");
        Student studentToUpdate = (Student)query.list().get(0);
        studentToUpdate.setName("Lakis");
    	session.saveOrUpdate(studentToUpdate);
        session.getTransaction().commit();

      //test delete
        System.out.println("*** Test Delete ***");
        session.beginTransaction();
        session.delete(studentToUpdate);
        session.getTransaction().commit();

    }
}
