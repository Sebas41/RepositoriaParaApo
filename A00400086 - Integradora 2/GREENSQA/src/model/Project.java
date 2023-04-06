package model;
public class Project {
    private String nameProject;
    private String nameClient;
    private Date dateStart;
    private Date dateEnd;
    private double budget;
    private String nameManager;
    private int phoneManager;
    private Stage[] stages = new Stage [6];

    public Project(String nProject, String nClient, Date dStart, Date dEnd, double pre, String nManager, int pManager) {
        nameProject= nProject; 
        nameClient= nClient; 
        dateStart = dStart; 
        dateEnd = dStart;
        budget= pre;
        nameManager= nManager;
        phoneManager = pManager;
    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public int getPhoneManager() {
        return phoneManager;
    }

    public void setPhoneManager(int phoneManager) {
        this.phoneManager = phoneManager;
    }

    public Stage[] getStages() {
        return stages;
    }

    public void setStages(Stage[] stages) {
        this.stages = stages;
    }

    


}
