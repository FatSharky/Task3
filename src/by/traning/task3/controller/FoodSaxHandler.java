package by.traning.task3.controller;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.traning.task3.domain.Food;
import by.traning.task3.domain.FoodTagName;

public class FoodSaxHandler extends DefaultHandler {
	private List<Food> foodList = new ArrayList<Food>();
	private Food food;
	private StringBuilder text;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing started.");
	}
	
	@Override
	public void endDocument() throws SAXException {

		System.out.println("Parsing ended");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("StartElement-> "+ "uri: " +uri+", localName:"+localName+", qName: "+qName);
		text = new StringBuilder();
		if(qName.equals("food")){
			food = new Food();
			food.setId(text.toString());
		}
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch,start,length);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		FoodTagName tagName = FoodTagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch (tagName) {
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
		case FOOD:
			foodList.add(food);
			food=null;
			break;
		default:
			break;
		
		}
	}
	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.err.println("WARNING: line "+ e.getLineNumber()+": "+e.getMessage());
	}
	@Override
	public void error(SAXParseException e) throws SAXException {
		System.err.println("ERROR: line "+e.getLineNumber()+": " + e.getMessage());
	}
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.err.println("FATAL ERROR: line "+e.getLineNumber()+": " + e.getMessage());
		throw(e);
	}

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public StringBuilder getText() {
		return text;
	}

	public void setText(StringBuilder text) {
		this.text = text;
	}

}
