package model;

/**
 * The PremiumUser class extends the User class and adds a PremiumCategory attribute, with methods to
 * set and get the category and a toString method to display the user's information.
 */
public class PremiumUser extends User {
    private PremiumCategory PremiumCategory;

    public PremiumUser(String id, String name, String nickname, PremiumCategory Premiumcategory) {
		super(id, name, nickname);
        this.PremiumCategory = Premiumcategory;
	}

    @Override
    public String toString() {
        String msg="\nID: "+this.getId()+"\nNombre: "+getName()+"\nNickname: "+getNickname()+"\nCategoria: "+PremiumCategory;
        return msg;
    }

    public void setPremiumcategory(PremiumCategory premiumcategory) {
        PremiumCategory = premiumcategory;
    }
}
