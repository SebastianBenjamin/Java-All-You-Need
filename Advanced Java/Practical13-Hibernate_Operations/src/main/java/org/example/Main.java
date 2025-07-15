package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        try{
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Scanner scanner = new Scanner(System.in);
            boolean boo = true;
            while(boo) {
                System.out.print("Choose Menu : \n 1: Insert \n 2: Fetch \n 3: Fetch all\n 4:Exit \n your selection : ");

                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.print("Enter no of student u want to enter : ");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        Student student = new Student();
                        System.out.print("Enter the id of student " + (i+1) + ":");
                        student.setId(scanner.next());
                        System.out.println();
                        System.out.print("Enter the first name of student " + (i+1) + ":");
                        student.setFirstName(scanner.next());
                        System.out.println();
                        System.out.print("Enter the last name of student " + (i+1) + ":");
                        student.setLastName(scanner.next());
                        System.out.println();
                        System.out.print("Enter the email of student " + (i+1) + ":");
                        student.setEmail(scanner.next());
                        System.out.println();
                        System.out.print("Enter the date of student " + (i+1) + ":");
                        student.setDate(scanner.next());
                        System.out.println();
                        System.out.println("Data Inserted");
                        session.persist(student);
                        transaction.commit();
                        session.close();

                    }
                } else if (choice == 2) {
                    System.out.print("Enter the id of student :");
                    Student student = session.get(Student.class, scanner.next());
                    System.out.println("id of student :"+student.getId());
                    System.out.println("first name of student :"+student.getFirstName());
                    System.out.println("last name of student :"+student.getLastName());
                    System.out.println("email of student :"+student.getEmail());
                    System.out.println("date of student :"+student.getDate());

                } else if (choice == 3) {
                    String hqlQuery = "from Student " ;
                    List<Student> students=new ArrayList<>();
                    students=session.createQuery(hqlQuery).getResultList();
                    for (Student student : students) {
                        System.out.println("id of student :"+student.getId());
                        System.out.println("first name of student :"+student.getFirstName());
                        System.out.println("last name of student :"+student.getLastName());
                        System.out.println("email of student :"+student.getEmail());
                        System.out.println("date of student :"+student.getDate());
                    }



                } else {
                    return;
                }
                System.out.print(" Do you want to exit ? \n 1: yes \n 2: no \n your selection : ");
                int choice2 = scanner.nextInt();
                if (choice2 == 1) {boo=false;}
                System.out.println();
            }
        }


        catch(Exception e){
            System.out.println(e.getMessage());
        }



    }

}
