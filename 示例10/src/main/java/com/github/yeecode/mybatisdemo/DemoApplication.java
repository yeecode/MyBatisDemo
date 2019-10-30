package com.github.yeecode.mybatisdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        try {
            String resource = "info.xml";
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));

            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();

            XPathExpression compile = xpath.compile("/members/user[id=1]");
            System.out.println(compile.evaluate(doc));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
