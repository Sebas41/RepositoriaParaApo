package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * this class is responsible for having the properties of each project and being
 * able to access the stage and person classes
 */

public class ProjectSQA {
	private String name;
	private double budget;
	private Calendar endDate;
	private Calendar realEnd;
	private Calendar startDate;
	private Person client;
	private Person managers;
	private int counterStage = 0;

	private SimpleDateFormat view = new SimpleDateFormat("dd/MM/yyyy 'hours: ' hh:mm:ss a");
	private Stage stage[] = {
			new Stage(TypeStage.Start),
			new Stage(TypeStage.Analysis),
			new Stage(TypeStage.Design),
			new Stage(TypeStage.Execution),
			new Stage(TypeStage.Clouse),
			new Stage(TypeStage.MonitoringAndControl)
	};

	/**
	 * Control method to return a stage
	 * 
	 * @param pos Position of the stage array
	 * @return stage to look for
	 */

	public Stage getStage(int pos) {
		return this.stage[pos];
	}//

	/**
	 * control method that returns the position of the current stage of a project
	 * 
	 * @return number of the position
	 */

	public int counStage() {
		return counterStage;
	}

	/**
	 * constructor method of Project object, activate the start stage at once and
	 * save the actual and planned start date of this stage
	 * 
	 * @param name
	 * @param startDate
	 * @param budget
	 */
	
	public ProjectSQA(String name, Calendar startDate, double budget) {
		this.name = name;
		this.startDate = (Calendar) startDate.clone();
		this.budget = budget;

		stage[0].setRealStart((Calendar) startDate.clone());
		stage[0].setStart((Calendar) startDate.clone());
		stage[0].setMode(true);
	}

	/**
	 * Control method that is responsible for registering the client or manager
	 * according to their type *
	 * * @param name
	 * * @param phone
	 * * @param typePerson
	 * * @return registration successful
	 */

	public String registerPerson(String name, String phone, String typePerson) {

		String register = name + "'s data was registered successfully\n";

		if (typePerson == "Clients") {
			client = new Person(name, phone, "Costumer");
		} else {
			managers = new Person(name, phone, "Manager of the project");
		}
		return register;
	}

	/**
	 * Method in charge of recording the planned start and end dates of each of the
	 * stages, through the amounts of duration
	 * 
	 * @param month Array containing the length of each month
	 * @return message of successful registration, and the planned start and end
	 *         dates of the project
	 */
	 
	public String assingDate(int[] month) {

		String init = view.format(this.startDate.getTime()); 

		stage[0].setEnd( (Calendar) stage[0].getStart().clone() );
		stage[0].getEnd().add(Calendar.MONTH, month[0]);

		for (int j = 1; j < month.length; j++) {

			stage[j].setStart(  (Calendar) stage[j - 1].getEnd().clone()  );
			stage[j].setEnd((Calendar) stage[j].getStart().clone());
			stage[j].getEnd().add(Calendar.MONTH, month[j]);

		}

		this.endDate = (Calendar) stage[5].getEnd().clone();
		return "The assing from the month was resgistered successfully\n" + name +
				" project: \n-Planned Start date= " + init + "\n-Planned end date= "
				+ view.format(this.endDate.getTime());
	}

	/**
	 * Control method that is responsible for approving the stages, changing its
	 * mode to deactivated and activating the next one. If you see that the last
	 * stage is already approved, it sends a message that all the stages were
	 * updated and shows the actual start and end dates of the project.
	 * 
	 * @param realEnd
	 * @return
	 */

	public String approbationStage(Calendar realEnd) {

		String approbation = "";
		String init = view.format(this.startDate.getTime());

		if (stage[counterStage].getMode() != false) {

			stage[counterStage].setMode(false);
			stage[counterStage].setRealEnd((Calendar) realEnd.clone());

			approbation = "The stage " + getStage(counterStage).getType() + " was approved on "
					+ view.format(stage[counterStage].getRealEnd().getTime());

			if (counterStage < 5) {
				this.realEnd = realEnd;
				stage[++counterStage].setRealStart((Calendar) realEnd.clone());
				stage[counterStage].setMode(true);

			}
		} else {
			approbation = "All the stage was approved. " + name + "'s project:\n-Real start date:" +
					init + "\n-Real end Date: " + view.format(this.realEnd.getTime());
		}
		return approbation;

	}

	/**
	 * This control method builds a message from a variable with the name of the
	 * project, with the information returned by the lessons of the selected stage.
	 * 
	 * @param pos Positon of the stage selected
	 * @return name of the project and recorded lessons of the stage
	 */
	
	public String lessonStage(int pos) {
		StringBuilder msg = new StringBuilder();
		msg.append("Project: " + name);
		msg.append("\n" + stage[pos].lessonStage());
		return msg.toString();
	}

	/**
	 * @return the name of the project
	 */
	public String getName() {
		return name;
	}//

	/**
	 * 
	 * @param realEnd Save the final end date of the project
	 */
	public void setRealEnd(Calendar realEnd) {
		this.realEnd = realEnd;
	}

	/**
	 * The function calculates the total number of capsules in a stage by summing up the capsule counters
	 * of all the objects in the stage array.
	 * 
	 * @return The method `capsuleCounter()` returns an integer value which represents the total number of
	 * capsules in the `stage` array.
	 */
	
	public int capsuleCounter(){
		int amountCapsule=0;
			for (int i = 0; i < stage.length; i++) {
				amountCapsule+=stage[i].getCapCouter();
			}	
		return amountCapsule;
	}

}