package by.traning.task3.controller;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import by.traning.task3.domain.Dish;
import by.traning.task3.domain.Kind;
import by.traning.task3.domain.Menu;


public class MenuSAXHandler extends DefaultHandler {
	private Menu menu;
	private Kind currentKind;
	private Dish currentDish;
	private StringBuilder text;

	public Menu getMenu() {
		return menu;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
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
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
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
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text = new StringBuilder(length);
		text.append(ch, start, length);
	}
}
