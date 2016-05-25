package by.traning.task3.controller;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.traning.task3.domain.Food;
import by.traning.task3.domain.FoodTagName;

public class FoodHandler extends DefaultHandler{
	private Set<Food> food;
	private Food current = null;
	private FoodTagName currentEnum=null;
	private EnumSet<FoodTagName> withText;
	public FoodHandler() {
		food = new HashSet<Food>();
		withText = EnumSet.range(FoodTagName.TYPE, FoodTagName.PRICE);
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if("food".equals(localName)){
			current = new Food();
			current.setId(attributes.getValue(0));
			if (attributes.getLength()==2){
				current.setName(attributes.getValue(1));
			}
		} else {
			FoodTagName temp = FoodTagName.valueOf(localName.toUpperCase());
			if (withText.contains(temp)){
				currentEnum = temp;
			}
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if("food".equals(localName)){
			food.add(current);
		}
	}
	
	public Set<Food> getFood() {
		return food;
	}
	public void setFood(Set<Food> food) {
		this.food = food;
	}
	public Food getCurrent() {
		return current;
	}
	public void setCurrent(Food current) {
		this.current = current;
	}
	public FoodTagName getCurrentEnum() {
		return currentEnum;
	}
	public void setCurrentEnum(FoodTagName currentEnum) {
		this.currentEnum = currentEnum;
	}
	public EnumSet<FoodTagName> getWithText() {
		return withText;
	}
	public void setWithText(EnumSet<FoodTagName> withText) {
		this.withText = withText;
	}
}
