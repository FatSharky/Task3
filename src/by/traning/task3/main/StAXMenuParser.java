package by.traning.task3.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.traning.task3.controller.StAXProcess;
import by.traning.task3.domain.Dish;
import by.traning.task3.domain.Kind;
import by.traning.task3.domain.Menu;
import by.traning.task3.interfaces.TagNames;

public class StAXMenuParser implements TagNames {

	public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
		XMLStreamReader xmlStreamReader = xmlInputFactory
				.createXMLStreamReader(new FileInputStream(new File(XML_FILE_URI)));
		StAXProcess stax = new StAXProcess();
		Menu menu = stax.readMenu(xmlStreamReader);
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
