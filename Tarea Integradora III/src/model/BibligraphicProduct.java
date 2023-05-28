package model;
import java.time.LocalDate;
public abstract class BibligraphicProduct implements Affordable {
    
    private String productID;
    private String productName;
    private LocalDate vinculationDate;
    private int numberPag;
    private String url;
    private String description;
    private LocalDate publicationDate;
    private int numberPagRead;



    public BibligraphicProduct(String productID, String productName, LocalDate  publicationDate, int numberPag,
         String url, String description) {
        this.productID = productID;
        this.productName = productName;
        this.numberPag = numberPag;
        this.url = url;
        this.description = description;
        this.publicationDate = publicationDate;
        this.numberPagRead = 0;
    }
    public String getProductID() {
        return productID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public LocalDate getVinculationDate() {
        return vinculationDate;
    }
    public void setVinculationDate(LocalDate vinculationDate) {
        this.vinculationDate = vinculationDate;
    }
    public int getNumberPag() {
        return numberPag;
    }
    public void setNumberPag(int numberPag) {
        this.numberPag = numberPag;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberPagRead() {
        return numberPagRead;
    }
    public void setNumberPagRead(int numberPagRead) {
        this.numberPagRead = numberPagRead;
    }
    
}



