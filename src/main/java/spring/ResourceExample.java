package spring;

import org.springframework.core.io.ClassPathResource;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * Created by qinyuan on 14-7-16.
 */
public class ResourceExample {

    public static void main(String[] args) throws Exception {
        ClassPathResource resource = new ClassPathResource("metrics-filter.xml");
        InputStream is = resource.getInputStream();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(is, new MyHandler());
    }

    private static class MyHandler extends DefaultHandler {
        private void print(Object... objects) {
            for (Object object : objects) {
                System.out.print(object + ";\t");
            }
            System.out.println();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            print("startElement", uri, localName, qName, attributes.getLength());
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            print("endElement", uri, localName, qName);
        }

        @Override
        public void startDocument() throws SAXException {
            System.out.println("startDocument");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("endDocument");
        }
    }
}
