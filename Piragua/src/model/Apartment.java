package model;

public class Apartment extends Property{
private String apartmentCode;
    int night = 35000;
    

    public Apartment(String name, String city, String address, int roomCount, String apartmentCode) {
        super(name, city, address, roomCount);
        this.apartmentCode = apartmentCode;
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
