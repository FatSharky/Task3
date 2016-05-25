package by.traning.task3.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.traning.task3.controller.StAXProcess;
import by.traning.task3.domain.Food;
import by.traning.task3.domain.FoodTagName;

public class StAXMenuParser {

	public static void main(String[] args) throws FileNotFoundException {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("Menu.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			List<Food> menu = process(reader);
			for (Food food:menu){
				System.out.println(food.getName());
				System.out.println(food.getType());
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}
	
	private static List<Food> process(XMLStreamReader reader) throws XMLStreamException {

		List<Food> menu = new ArrayList<Food>();
		Food food = null;
		FoodTagName elementname = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementname = FoodTagName.getElementTagName(reader.getLocalName());
				switch (elementname) {
				case FOOD:
					food = new Food();
					String id = reader.getAttributeValue(null, "ID").trim();
					food.setId(id);
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();

				if (text.isEmpty()) {
					break;
				}
				switch (elementname) {
				case TYPE:
					food.setType(text.toString());
					break;
				case NAME:
					food.setName(text.toString());
					break;
				case PHOTO:
					food.setPhoto(text.toString());
					break;
				case DESCRIPTION:
					food.setDescription(text.toString());
					break;
				case PORTION:
					food.setPortion(text.toString());
					break;
				case PRICE:
					food.setPrice(Integer.parseInt(text.toString()));
					break;

				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementname = FoodTagName.getElementTagName(reader.getLocalName());
				switch (elementname) {
				case FOOD:
					menu.add(food);
				}
			}
		}

		return menu;

	}

}
