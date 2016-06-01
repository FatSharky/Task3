package by.traning.task3.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


import by.traning.task3.controller.MenuSAXHandler;
import by.traning.task3.domain.Dish;
import by.traning.task3.domain.Kind;
import by.traning.task3.domain.Menu;

public class SAXMenuParser{

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		MenuSAXHandler handler = new MenuSAXHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource(new FileInputStream(new File(Path.XML_FILE_URI))));
		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		Menu menu = handler.getMenu();
		System.out.println("Меню:\n");
		for (Kind kind : menu.getKinds()) {
			System.out.println(kind.getName());
			for (Dish dish : kind.getDishes()) {
				System.out.println("Фото: " + dish.getPhoto() + " Название: " + dish.getName() + " Описание: "
						+ dish.getDescription() + " Порция: " + dish.getPortion() + " Цена: " + dish.getPrice());
			}

		}

	}

}
