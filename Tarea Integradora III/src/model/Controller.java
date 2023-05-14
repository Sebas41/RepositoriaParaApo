package model;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {
    private User[] users;
    private Book[] books;
	//private Book currentBook;
	private Transaction[] transactions;
	private int amoBooks = 0;
    

// The `public Controller()` method is a constructor for the `Controller` class. It initializes an
// array of `User` objects with a length of 10 and then calls the `testCases()` method to initialize
// two `User` objects with their respective attributes.
	public Controller() {
		users = new User[10];
        books = new Book[50];
		transactions = new Transaction[1000];
		//lines();
	}


/**
 * The function returns a formatted string containing the list of users' IDs and names.
 * 
 * @return The method `getUserList()` returns a `String` containing a list of users' IDs and names.
 */
	public String getUserList() {
		String msg = "";
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null) {
				msg += "\n" + (i + 1) + ". " + users[i].getId() + " - " + users[i].getName();
			}
		}
		return msg;
	}

/**
 * The function registers a new user with their ID, name, nickname, user type, and premium category (if
 * applicable) and returns a boolean indicating if the registration was successful.
 * 
 * @param id a String representing the user's ID
 * @param name The name of the user being registered.
 * @param nickname The nickname parameter is a String that represents the desired nickname for the user
 * being registered.
 * @param userType An integer representing the type of user to be registered. 1 represents a standard
 * user and 2 represents a premium user.
 * @param newCategory an integer representing the category of a new PremiumUser being registered. It
 * can have the values 1, 2, or 3, which correspond to the PLATA, ORO, and DIAMANTE categories
 * respectively.
 * @return The method is returning a boolean value, which indicates whether the user registration was
 * successful or not. If the registration was successful, the method returns true, otherwise it returns
 * false.
 */

	public boolean registerUser(String id, String name, String nickname, int userType,int newCategory) {
		
		boolean flag = false;

		for(int i=0; i<users.length;i++){

            if(users[i] == null && !flag){
				switch(userType){
					case 1:
						users[i] = new StandardUser(id, name, nickname);
						flag = true;
					break;

					case 2:
						PremiumCategory premiumCategory = null;
						switch(newCategory){
							case 1 -> premiumCategory = PremiumCategory.PLATA;
							case 2 -> premiumCategory = PremiumCategory.ORO;
							case 3 -> premiumCategory = PremiumCategory.DIAMANTE;
						}
						users[i] = new PremiumUser(id, name, nickname,premiumCategory);
						flag = true;
					break;
				}
			}
		}
		return flag;
	}

/**
 * This function edits a user's information, including their name, nickname, and premium category, and
 * returns a boolean indicating whether the edit was successful.
 * 
 * @param userPosition The position of the user in the array of users that needs to be edited.
 * @param categoryC An integer representing the category of user information to be edited.
 * @param newCategory An integer representing the new premium category that the user wants to switch
 * to. It can be 1, 2, 3, or 4, where 1 represents switching to a standard user account and 2, 3, and 4
 * represent switching to different premium categories.
 * @param msg A String representing the new value to be set for the user's name or nickname, depending
 * on the value of categoryC.
 * @return The method returns a boolean value indicating whether the user was successfully edited or
 * not.
 */
	public boolean editUser(int userPosition, int categoryC, int newCategory, String msg) {

		boolean flag = false;
		switch(categoryC){
			case 1:
			users[userPosition].setName(msg);
			flag = true;
			break;

			case 2:
			users[userPosition].setNickname(msg);
			flag = true;
			break;

			case 3:
			PremiumCategory premiumCategory = null;
			switch(newCategory){

				case 1:
					if(users[userPosition] instanceof PremiumUser){
						for(int i =0;i<users.length;i++){
							if(users[i]==null){
								StandardUser tempUser = new StandardUser(users[userPosition].getId(),users[userPosition].getName() , users[userPosition].getNickname());
								users[userPosition]=tempUser;
								return true;
							}
						}
					}else{
					return false;
				}
				case 2: premiumCategory = PremiumCategory.PLATA;
				break;
				case 3: premiumCategory = PremiumCategory.ORO;
				break;
				case 4: premiumCategory = PremiumCategory.DIAMANTE;
				break;
			}

			if(users[userPosition] instanceof PremiumUser){
				((PremiumUser)users[userPosition]).setPremiumcategory(premiumCategory);
				return true;
			}

			if(users[userPosition] instanceof StandardUser){
				for(int i =0;i<users.length;i++){
					if(users[i]==null){
						PremiumUser tempUser = new PremiumUser(users[userPosition].getId(),users[userPosition].getName() , users[userPosition].getNickname(), premiumCategory);
						users[userPosition]=tempUser;
						return true;
					}
				}
			}
		}

		return flag;
	}

/**
 * This Java function deletes a user from an array of users at a specified position and returns a
 * boolean flag indicating whether the deletion was successful.
 * 
 * @param userPosition The position of the user in the array of users that needs to be deleted.
 * @return A boolean value indicating whether the deletion was successful or not. In this case, the
 * method always returns true.
 */
	public boolean deleteUser(int userPosition) {
		boolean flag = true;
		users[userPosition]=null;
		return flag;
	}

/**
 * This Java function returns a string containing user information based on the input option.
 * 
 * @param option The index of the user in the "users" array whose information is to be retrieved.
 * @return A string containing information about a user, based on the option parameter passed to the
 * method.
 */
	public String getUserInfo(int option) {

		String msg = "";
		msg =users[option].toString();
		return msg;
	}

/**
 * The function returns a concatenated string of all non-null user information in an array.
 * 
 * @return The method is returning a String that contains information about all the users in the
 * system.
 */
	public String getAllUserInfo() {

		String msg = "";
		for(int i=0;i<users.length;i++){
			if(users[i] == null){
				
			}
			else{
				msg+=users[i].toString();
			}
		}
		return msg;
	}

    public boolean registerBook(String id, String name, int genre, double price) {

		Genre genretype = null;

		switch (genre){
			case 1 -> genretype = Genre.SCIENCEFICTION;
			case 2 -> genretype = Genre.FANTASY;
			case 3 -> genretype = Genre.NOVEL;	
		}

        if (amoBooks != books.length) {
            //currentBook = books[amoBooks];
            amoBooks++;
			return true;
        }
        return false;
	}

	public String getBookList() {

		String msg = "";

		for (int i = 0; i < books.length; i++) {

			if (books[i] != null) {
				msg += "\n" + (i + 1) + ". " + books[i].getName() + " - " + books[i].getPrice();
			}

		}
		
		return msg;

	}

	public boolean sellItem(int i, int day, int month, int year) {

		Calendar date = new GregorianCalendar(day,month,year);

			if (books[i] != null){

				int sold = (int) books[i].getUnitsSold();
				
				for (int n = 0;n<transactions.length;n++){
					String bookName = books[i].getName();
					Double purschaseValue = books[i].getPrice();
					Double ingreso = books[i].getIngreso();

					Transaction newTransaction = new Transaction(date, purschaseValue);

					if (transactions[n] == null){
						
						transactions[n]=newTransaction;
						transactions[n].setDate(date);
						transactions[n].setBookName(bookName);
						books[i].setUnitsSold(sold);
						books[i].setIngreso(ingreso+purschaseValue);
					}
				}
			}
			

		return false;
	}

	public String getAllItemInfo() {

		String msg = "";

		for (int i = 0; i < books.length; i++) {

			if (books[i] != null) {
				msg += "\n" + (i + 1) + ". " + books[i].getName() + books[i].getPrice() + books[i].getUnitsSold() + books[i].getIngreso() ;
			}

		}

		return msg;
	}

	public boolean sellBook(int i) {
		return false;
	}
}
