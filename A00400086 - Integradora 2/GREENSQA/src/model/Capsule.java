package model;

public class Capsule {
    private String id;
	private String description;
    private CapsuleType type;
    private String learnedLessons;
    private String nameCol;
    private String cargoCol;
    private boolean active;
    private Date aprobDate;

    public Capsule(String id, String description, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.learnedLessons = learnedLessons;
		this.active = false;
    
    }


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    
	public String getNameCol() {
        return nameCol;
    }


    public void setNameCol(String nameCol) {
        this.nameCol = nameCol;
    }


    public String getCargoCol() {
        return cargoCol;
    }


    public void setCargoCol(String cargoCol) {
        this.cargoCol = cargoCol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	public String getLearnedLessons() {
		return learnedLessons;
	}


	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}

    public CapsuleType getType() {
        return type;
    }


    public void setType(CapsuleType type) {
        this.type = type;
    }

    public Date getAprobDate() {
        return aprobDate;
    }


    public void setAprobDate(Date aprobDate) {
        this.aprobDate = aprobDate;
    }

}
