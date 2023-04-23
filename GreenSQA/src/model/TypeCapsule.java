package model;

/**
  * Enumeration of the types of capsules
  */

public enum TypeCapsule {

	Tecnic("Technical"),
	Manage("Management"),
	Domain("Domain-specific"),
	Experience("Experience-based");

	public final String type;

	TypeCapsule(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}