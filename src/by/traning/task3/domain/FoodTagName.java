package by.traning.task3.domain;

public enum FoodTagName {

	FOOD, TYPE, PHOTO, NAME, DESCRIPTION, PORTION, PRICE, MENU;
	
	public static FoodTagName getElementTagName(String element){
		switch (element) {
		case "food":
			return FOOD;
			
		case "type":
			return TYPE;
			
		case "name":
			return NAME;
			
		case "photo":
			return PHOTO;
			
		case "description":
			return DESCRIPTION;
	
		case "portion":
			return PORTION;
			
		case "price":
			return PRICE;
			

		default: throw new EnumConstantNotPresentException(FoodTagName.class, element);
		
		
		}
	}

	
}
