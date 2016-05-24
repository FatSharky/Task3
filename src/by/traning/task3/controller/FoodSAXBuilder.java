package by.traning.task3.controller;

import java.io.IOException;
import java.util.Set;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.traning.task3.domain.Food;

public class FoodSAXBuilder {
	private Set<Food> food;
	private FoodHandler fh;
	private XMLReader reader;

public FoodSAXBuilder() {
	//Cоздание SAX-анализатора
	fh = new FoodHandler();
	try {
		reader = XMLReaderFactory.createXMLReader();
		reader.setContentHandler(fh);
	} catch (SAXException e) {
		System.err.println("Ошибка SAX парсера:"+e);// TODO: handle exception
	}
}
public void buildSetFood(String fileName){
	try {
		 // разбор XML-документа
		 reader.parse(fileName);
		 } catch (SAXException e) {
		 System.err.print("ошибка SAX парсера: " + e);
		 } catch (IOException e) {
		 System.err.print("ошибка I/О потока: " + e);
		 }
		 food = fh.getFood();
		}
}

	public Set<Food> getFood() {
		return food;
	}

	public void setFood(Set<Food> food) {
		this.food = food;
	}

	public FoodHandler getFh() {
		return fh;
	}

	public void setFh(FoodHandler fh) {
		this.fh = fh;
	}

	public XMLReader getReader() {
		return reader;
	}

	public void setReader(XMLReader reader) {
		this.reader = reader;
	}

}
