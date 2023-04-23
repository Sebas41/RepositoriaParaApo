package model;

import java.util.Calendar;

/**
 * This capsule class has the properties of a capsule object
 */

public class Capsule {

	private String id;
	private String description;
	private TypeCapsule typeCapsule;
	private String Collaborator;
	private String charge;
	private String learning;
	private Calendar aprobationDate = null;
	private boolean aprobation = false;
	private String hashtag[] = new String[20];
	private boolean publish=false;
	
	/**
	 * Builder method from the Capsule class
	 * 
	 * @param id
	 * @param description
	 * @param typeCapsule
	 * @param nameColaborator
	 * @param position
	 * @param learning
	 */

	public Capsule(String id, String description, TypeCapsule typeCapsule, String Collaborator, String charge,
			String learning, String[] hashtag) {
		this.id = id;
		this.description = description;
		this.typeCapsule = typeCapsule;
		this.Collaborator = Collaborator;
		this.charge = charge;
		this.learning = learning;
		this.hashtag = hashtag;
	}

	public String getId() {
		return id;
	}

	public boolean getPublish(){
		return this.publish;
	}

	public void setPublish(boolean publish){
		this.publish = publish;
	}

	public void setAprobation(boolean aprobation) {
		this.aprobation = aprobation;
	}
	
	public boolean getAprobation(){
		return this.aprobation;
	}

	public String[] getHashtag() {
		return hashtag;
	}

	public void setAprobationDate(Calendar aprobaDate) {
		this.aprobationDate = aprobaDate;

	}

	public Calendar getAprobationDate() {
		return aprobationDate;
	}

	public String toString() {
		StringBuilder capsule = new StringBuilder();
		capsule.append("\n \nCapsule: " + id);
		capsule.append("\tCollaborator: " + Collaborator);
		capsule.append("\tCharge: " + charge);
		capsule.append("\n\3Description of the situation: " + description);
		capsule.append("\n\3Lesson learned: " + learning);
		return capsule.toString();
	}

	public String getTypeCapsule() {
		return typeCapsule.getType();
	}

	public String getCollaborator() {
		return Collaborator;
	}
	
	public String getLearning() {
		return learning;
	}
}