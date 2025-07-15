package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlValidate extends DefaultHandler {
    public static void main(String[] args) {
        String xmlFile="src/main/resources/data/students.xml";

        try{
            XmlValidate validator = new XmlValidate();
            validator.validate(xmlFile);
            System.out.println("Validation successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void validate(String xmlFile) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        SAXParser parser = factory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setErrorHandler(this);

        reader.parse(new InputSource(xmlFile));

    }

    public void error(SAXParseException exception) throws SAXException {
        System.err.println(exception.getMessage());
        throw new SAXException("SAXParseException", exception) ;
    }
}