package by.traning.task3.domain;

public enum FoodEnum {

	FOOD("food"), TYPE("type"), PHOTO("photo"), NAME("name"), DESCRIPTION("description"), PORTION("portion"), PRICE(
			"price");
	private String value;

	FoodEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
