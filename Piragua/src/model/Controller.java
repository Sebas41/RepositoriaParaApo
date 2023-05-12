package model;

public class Controller {

	private Property[] properties;

	public Controller() {

		this.properties = new Property[10];
		testCases();

	}

	public void testCases() {

		//properties[0] = new Property("Vila Verde", "Cali", "Cra 4 # 57 - 23", 3);
		//properties[1] = new Property("Palmar", "Palmira", "Calle 6 # 4 - 12", 4);
	}

	public String getProperties() {

		String propertiesRegistered = "";

		for (int i = 0; (i < properties.length); i++) {

			if (properties[i] != null) {

				propertiesRegistered += "\n" + (i + 1) + ". " + properties[i].getName() + " - "
						+ properties[i].getCity();

			}

		}

		return propertiesRegistered;

	}

	public boolean registerProperty(String propertyName, String city, String address, int roomCount,int propertyType,String temp) {

		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {

				if (propertyType == 1){
					properties[i] = new Apartment(propertyName, city, address, roomCount,temp);
				}

				if (propertyType == 2){
					properties[i] = new House(propertyName, city, address, roomCount,temp);
				}
				
				return true;
			}

		}
		return false;
	}

	public String bookProperty(int i, int nights) {
		String msg = "";
		if(properties[i] instanceof House){
			msg+=((House)properties[i]).calculateReservation(nights);
		}
		if(properties[i] instanceof Apartment){
			msg+=((Apartment)properties[i]).calculateReservation(nights);
		}
		return msg;
	}

}
