package by.traning.task3.main;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.traning.task3.controller.SimpleFoodHandler;

public class SAXSimpleMain {

	public static void main(String[] args) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			SimpleFoodHandler handler = new SimpleFoodHandler();
			reader.setContentHandler(handler);
			reader.parse("Menu.xml");
		} catch (SAXException e) {
			System.err.println("������ SAX ������� " + e);
		} catch (IOException e) {
			System.err.println("������ I/O ������" + e);
		}

	}

}
