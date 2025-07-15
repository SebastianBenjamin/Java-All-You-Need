package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try{
            Configuration config = new Configuration().configure();
            SessionFactory sessionFactory = config.buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Student student = new Student();
            student.setFirstName("Benjamin");
            student.setLastName("Sebastian");
            student.setEmail("b.sebastian@somaiya.edu");
            student.setId("1");
            student.setDate("1-1-2025");
            session.save(student);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            System.out.println("Student with ID " + student.getId() + " has been saved to the database using Hibernate");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
