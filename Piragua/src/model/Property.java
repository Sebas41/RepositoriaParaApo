package model;

public abstract class Property implements Hosted{

	private String name;
	private String city;
	private String address;
	private int roomCount;

	public Property(String name, String city, String address, int roomCount) {
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.roomCount = roomCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

}
