package org.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class XmlCreation {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many student details you would like to enter : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Id : " );
            int id = sc.nextInt();
            System.out.print("Name : " );
            String name = sc.next();
            System.out.print("Course : " );
            String course = sc.next();
            System.out.print("Age : " );
            int age = sc.nextInt();
                createStudent(id,name,age,course);
                System.out.println("\u001B[31m"+"Student created in student.xml!");
        }

    }
    public static void createStudent(int id,String name,int age ,String courseVar) throws ParserConfigurationException, TransformerException {
        Document document= DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        Element root=document.createElement("university");
        document.appendChild(root);

        Element student = document.createElement("student");
        student.setAttribute("id", String.valueOf(id));
        student.setAttribute("name", name);
        student.setAttribute("age", String.valueOf(age));

        Element course = document.createElement("course");
        course.setTextContent(courseVar);
        student.appendChild(course);
        student.appendChild(document.createComment("This is a comment of student "+id));
        root.appendChild(student);

        File dir = new File("src/main/resources/data");
        File xmlFile=new File(dir,"students.xml");
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer=tf.newTransformer();
        DOMSource source=new DOMSource(document);
        StreamResult result=new StreamResult(xmlFile);
        transformer.transform(source,result);
    }
}
