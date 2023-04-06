package model;

public class Stage {
	private TypeStage stagesType;
	private DateStage dateStage;
	private Capsule[] capProject = new Capsule[50];
	private boolean aprovedStage;
	
	public Stage(TypeStage stagesType, DateStage dateStage) {
		this.stagesType = stagesType;
		this.dateStage = dateStage;
	}

	public TypeStage getStagesType() {
		return stagesType;
	}
	public void setStagesType(TypeStage stagesType) {
		this.stagesType = stagesType;
	}
	public DateStage getDateStage() {
		return dateStage;
	}
	public void setDateStage(DateStage dateStage) {
		this.dateStage = dateStage;
	}
	public Capsule[] getCapProject() {
		return capProject;
	}
	public void setCapProject(Capsule[] capProject) {
		this.capProject = capProject;
	}
	public boolean isAprovedStage() {
		return aprovedStage;
	}
	public void setAprovedStage(boolean aprovedStage) {
		this.aprovedStage = aprovedStage;
	}
}