package by.traning.task3.controller;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import by.traning.task3.domain.Dish;
import by.traning.task3.domain.Kind;
import by.traning.task3.domain.Menu;
import by.traning.task3.interfaces.TagNames;

public class MenuSAXHandler extends DefaultHandler implements TagNames {
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
		case MENU_TAG:
			menu = new Menu();
			break;
		case KIND_TAG:
			currentKind = new Kind();
			break;
		case DISH_TAG:
			currentDish = new Dish();
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case KIND_TAG:
			menu.addKind(currentKind);
			break;
		case DISH_TAG:
			currentKind.addDish(currentDish);
			break;
		case KIND_NAME_TAG:
			currentKind.setName(text.toString());
			break;
		case PHOTO_TAG:
			currentDish.setPhoto(text.toString());
			break;
		case NAME_TAG:
			currentDish.setName(text.toString());
			break;
		case DESCRIPTION_TAG:
			currentDish.setDescription(text.toString());
			break;
		case PORTION_TAG:
			currentDish.setPortion(text.toString());
			break;
		case PRICE_TAG:
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
