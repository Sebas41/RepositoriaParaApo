package model;
import java.time.LocalDate;
public class RegularUser extends User {
    
    private int readPagBook;
    private int readPagMagazine;

    Bill [] bills = new Bill[7];
    private Book[] books = new Book[5];
    private Magazine[] magazines = new Magazine[2];

    public RegularUser(String cedula, String name, LocalDate vinculationDate) {
        super(cedula, name, vinculationDate);
        this.readPagBook = 0;
        this.readPagMagazine =0;
        
    }
    public int getReadPagBook() {
        return readPagBook;
    }
    public void setReadPagBook(int readPagBook) {
        this.readPagBook = readPagBook;
    }
    public int getReadPagMagazine() {
        return readPagMagazine;
    }
    public void setReadPagMagazine(int readPagMagazine) {
        this.readPagMagazine = readPagMagazine;
    }
   
   // The `buy` method is adding a new `Affordable` object to the user's collection of books or
   // magazines, depending on the type of the object passed as a parameter. If the object is a `Book`,
   // it is added to the `books` array, and if it is a `Magazine`, it is added to the `magazines`
   // array. The method checks for the first available slot in the corresponding array and adds the
   // object to that slot.
    public void buy(Affordable bill){
        if(bill instanceof Book){
            for(int i = 0; i <books.length; i++){
                if (books[i]==null){
                    books[i]= (Book) bill;
                }
            }
        }else {
            for (int i=0; i<magazines.length; i++){
                if(magazines[i]==null){
                    magazines[i]= (Magazine) bill;
                }
            }
        }
    }
}
