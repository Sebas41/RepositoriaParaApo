package model;

/**
 * The StandardUser class extends the User class and overrides the toString method to display the
 * user's ID, name, and nickname.
 */
public class StandardUser extends User{

    public StandardUser(String id, String name, String nickname) {
		super(id, name, nickname);
	}

	@Override
    public String toString() {
        String msg="\nID: "+this.getId()+"\nNombre: "+getName()+"\nNickname: "+getNickname();
        return msg;
    }
}