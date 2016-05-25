package by.traning.task3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.traning.task3.domain.Food;
import by.traning.task3.domain.FoodTagName;

public class StAXProcess {
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
