package by.traning.task3.controller;


import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.traning.task3.domain.Dish;
import by.traning.task3.domain.Kind;
import by.traning.task3.domain.Menu;


public class StAXProcess{

	public Menu readMenu(XMLStreamReader xmlStreamReader) throws XMLStreamException {
		Menu menu = null;
		Kind currentKind = null;
		Dish currentDish = null;
		StringBuilder text = null;

		while (xmlStreamReader.hasNext()) {

			switch (xmlStreamReader.next()) {

			case XMLStreamConstants.START_ELEMENT:
				switch (xmlStreamReader.getLocalName()) {
				case TagNames.MENU_TAG:
					menu = new Menu();
					break;
				case TagNames.KIND_TAG:
					currentKind = new Kind();
					break;
				case TagNames.DISH_TAG:
					currentDish = new Dish();
					break;
				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				switch (xmlStreamReader.getLocalName()) {
				case TagNames.KIND_TAG:
					menu.addKind(currentKind);
					break;
				case TagNames.DISH_TAG:
					currentKind.addDish(currentDish);
					break;
				case TagNames.KIND_NAME_TAG:
					currentKind.setName(text.toString());
					break;
				case TagNames.PHOTO_TAG:
					currentDish.setPhoto(text.toString());
					break;
				case TagNames.NAME_TAG:
					currentDish.setName(text.toString());
					break;
				case TagNames.DESCRIPTION_TAG:
					currentDish.setDescription(text.toString());
					break;
				case TagNames.PORTION_TAG:
					currentDish.setPortion(text.toString());
					break;
				case TagNames.PRICE_TAG:
					currentDish.setPrice(Integer.parseInt(text.toString()));
					break;
				}
				break;

			case XMLStreamConstants.CHARACTERS:
				text = new StringBuilder();
				text.append(xmlStreamReader.getText());
				break;

			}

		}

		return menu;
	}

}
