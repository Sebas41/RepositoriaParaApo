package model;

public class House extends Property {
    private String houseFloors;
    int night = 50000;

    public House(String name, String city, String address, int roomCount,String temp) {
        super(name, city, address, roomCount);
        this.houseFloors = temp;
    }
    
    @Override
	public  String calculateReservation(int nights) {
        String msg = "";
        int pricePerNight = (nights*night);
        int total = (night+pricePerNight);
        msg = "El total de su reserva es de: "+total + "\n El precio por noche es de: "+pricePerNight;
      return msg;
	}
}
