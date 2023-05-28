package model;
import java.time.LocalDate;
public class Magazine extends BibligraphicProduct{

    private Category category;
    private Periodicity periodicity;
    private double suscriptionValue;
    private int subcriptionActive;
    
    public Magazine(String productID, String productName, LocalDate publicationDate, int numberPag, String url,
            String description, Category category, Periodicity periodicity,
            double suscriptionValue) {
        super(productID, productName, publicationDate, numberPag, url, description);
        this.category = category;
        this.periodicity = periodicity;
        this.suscriptionValue = suscriptionValue;
            }
            // This is a constructor that creates a new Magazine object by copying the values of an
            // existing Magazine object. It calls the superclass constructor with the same parameters
            // as the existing Magazine object, and then sets the values of the category, periodicity,
            // and subscriptionValue variables to the corresponding values of the existing Magazine
            // object.
            public Magazine(Magazine magazine){
            super(magazine.getProductID(),magazine.getProductName(),magazine.getPublicationDate(),
            magazine.getNumberPag(),magazine.getUrl(),magazine.getDescription());
            this.category = magazine.getCategory();
            this.periodicity = magazine.getPeriodicity();
            this.suscriptionValue = magazine.getSuscriptionValue();
            }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Periodicity getPeriodicity() {
        return periodicity;
    }
    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
    public double getSuscriptionValue() {
        return suscriptionValue;
    }
    public void setSuscriptionValue(double suscriptionValue) {
        this.suscriptionValue = suscriptionValue;
    }
    public int getSubcriptionActive() {
        return subcriptionActive;
    }
    public void setSubcriptionActive(int subcriptionActive) {
        this.subcriptionActive = subcriptionActive;
    }
    /**
     * The function "affordar" increases the value of the "subscriptionActive" variable by 1.
     */
    public void affordar() {
        setSubcriptionActive( getSubcriptionActive() +1);

    }
    
   
}
    
    

    

    
    

