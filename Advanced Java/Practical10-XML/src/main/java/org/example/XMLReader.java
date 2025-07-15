package org.example;

    import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

    public class XMLReader {
        public static void main(String[] args) throws Exception {
            File file = new File("src/main/resources/data/students.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("student");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                Element element = (Element) node;

                System.out.println("Roll: " +
                        element.getElementsByTagName("roll").item(0).getTextContent());
                System.out.println("Name: " +
                        element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Course: " +
                        element.getElementsByTagName("course").item(0).getTextContent());
                System.out.println();
            }
        }
    }

