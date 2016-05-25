package by.traning.task3.main;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.traning.task3.controller.FoodSaxHandler;
import by.traning.task3.domain.Food;

public class SAXSimpleMain {

	public static void main(String[] args) throws SAXException, IOException {
		XMLReader reader = XMLReaderFactory.createXMLReader();
		FoodSaxHandler handler = new FoodSaxHandler();
		reader.setContentHandler(handler);
		reader.parse(new InputSource("Menu.xml"));
		reader.setFeature("http://xml.org/sax/features/validation", true);
		reader.setFeature("http://xml.org/sax/features/namespaces", true);
		reader.setFeature("http://xml.org/sax/features/string-interning", true);
		reader.setFeature("http://apache.org/xml/features/validation/schema", false);
		List<Food> menu = handler.getFoodList();
		for (Food food:menu){
			System.out.println("id="+food.getId()+
					"\nтип="+ food.getType()+
					"\nназвание="+food.getName()+
					"\nфото= "+food.getPhoto()+
					"\nописание="+food.getDescription()+
					"\nпорция="+food.getPortion()+
					"\nцена="+food.getPrice()+"\n");
	
}
	}

}
