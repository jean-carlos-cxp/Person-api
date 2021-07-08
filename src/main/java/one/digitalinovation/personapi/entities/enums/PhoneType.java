package one.digitalinovation.personapi.entities.enums;

public enum PhoneType {

	HOME(1, "Home"),
	MOBILE(2, "Mobile"),
	COMMERCIAL(3, "Commercial");
	
	private final Integer cod;
	private final String description;
	
	private PhoneType(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
}
