package ui;
import model.Controller;
import java.util.Calendar;
import java.util.Scanner;

/**
 * This class is where the main functional requirements of the integrator are
 * executed
 */
public class Executable {
	private Controller controller;
	private Scanner reader;

	/**
	 * Builder Method of the class Administration
	 */
	public Executable() {
		reader = new Scanner(System.in);
		controller = new Controller();
	}

	/**
	 * The main method of the application that starts the program and receives
	 * command line arguments.
	 * 
	 * @param args The command line arguments to be processed by the application.
	 */

	public static void main(String[] args) {
		double option = 0;
		boolean flag = false;

		Executable admin = new Executable();
		do {

			System.out.println("-GreenSQA Knowledgement manage-");
			System.out.println("1.Creacte project\n2.Search Project\n3.Culminate capsule\n4.Publish Capsule");
			System.out.println("5.Amount Capsule Type of all projects\n6.Lesson Stage");
			System.out.println("7.More amount capsules\n8.Search Capsules Collaborator\n9.Search Capsules\n0.Exit");

			do {
				System.out.print("What do you want to do?: ");
				option = admin.validateDouble();
			} while (!(option >= 0 && option <= 9 && option == Math.floor(option)));

			flag = admin.principalExecution((int) option);

			if (flag == true) {
				do {
					
					admin.menuProject();

					do {
						System.out.print("What do you want to do?: ");
						option = admin.validateDouble();
					} while (!(option >= 0 && option <= 6 && option == Math.floor(option)));

					admin.projectExecution((int) option);

				} while (option != 0 && option != 6);
			}
		} while (option != 0);
	}

	/**
	 * This function displays a menu for a project with options to register capsules, approve capsules,
	 * culminate stages, view capsule types, go to the lesson stage, go to the main menu, or exit.
	 */

	public void menuProject() {

		System.out.println(controller.projectName() + " Project menu");
		System.out.println("1.Register Capsule\n2.Aprobation Capsule\n3.Culminate Stage\n4.Amount capsule type of this project\n5.Lesson Stage\n6.Go to main menu\n0.Exit");
	}

	/**
	 * Runs the main sismeta menu, and returns a boolean yes to enter the project
	 * menu if found
	 * 
	 * @param option the option chosen by the user
	 * @return if true, you can enter the project menu otherwise it stays the same
	 */

	public boolean principalExecution(int option) {

		boolean flag = false;

		switch (option) {
			case 1:
				registerProject();
				flag = true;
				break;
			case 2:
				flag = searchProject();
				break;
			case 3:
				capsuleApproval();
				break;
			case 4:
				publishCapsules();
				break;
			case 5:
				System.out.println(controller.amountType(1));
				break;
			case 6:
				lessonStage(1);
				break;
			case 7:
				moreAmountCapsule();
				break;
			case 8:
				SearchColaboratorCapsule();
				break;
			case 9:
				searchCapsule();
				break;
			case 0:
				System.out.println("Exit");

		}
		return flag;
	}

	/**
	 * This method executes the project menu options, either register capsules,
	 * approve capsules or approve stages
	 */
	
	public void projectExecution(int option) {
		switch (option) {
			case 1 -> registerCapsule();
			case 2 -> capsuleApproval();
			case 3 -> approbationStage();
			case 4 -> System.out.println(controller.amountType(2));
			case 5 -> lessonStage(2);
			case 0 -> System.out.println("You went out of the program. ");
		}
	}



	/**
	 * This control method is responsible for registering the projects, entering the
	 * name and the amount of investment. In order to create a project object by
	 * calling the controller
	 */
	public void registerProject() {

		String name = "";
		Calendar startDate = Calendar.getInstance();
		double budget = 0;
		System.out.println("Register Projects");
		System.out.print("Type the project name: ");
		name = read(reader);
		System.out.print("Type the project budget: ");
		budget = validateDouble();
		controller.registerProject(name, startDate, budget);
		controller.searchProjectSQA(name);
		registerPerson();
		assingDate();
	}

	/**
	 * This control method registers the client and manager of an existing project
	 * by calling the registerPerson() method and printing the result if the
	 * registration was successful. It uses a for loop to recycle variables, and
	 * depending on the type of person, the system registers them in the appropriate
	 * place.
	 */
	private void registerPerson() {

		String name = "", phone = "";

		System.out.println("Register Client and Manager");
		for (int i = 0; i < 2; i++) {

			String typePerson = (i == 0) ? "Clients" : "Manager";
			System.out.print("Type the " + typePerson + " name: ");
			name = read(reader);
			System.out.print("Type the " + typePerson + " phone: ");
			phone = reader.next();
			System.out.println(controller.registerPerson(name, phone, typePerson));

		}
	}

	/**
	 * This control method assigns the duration of months of each stage going
	 * through a cycle
	 * stores them in an array of 6, with the goal of sending it to the class
	 * projectSQA and this assigns the start and end dates
	 * planned for each stage of the project
	 */
	public void assingDate() {

		int[] month = new int[6];

		System.out.println("Assing tha date for each stage \n How long months it will carry the ");

		for (int i = 0; i < month.length; i++) {
			System.out.print((i + 1) + ". " + controller.stageName(i) + "'s stage:  ");
			month[i] = reader.nextInt();
		}
		System.out.println(controller.assingDate(month));

	}

	/**
	 * This control method searches for a project and performs the actions shown in
	 * the menuProject on the current project if found.
	 * 
	 * @return a boolean, true if found, false otherwise
	 */
	public boolean searchProject() {
		String name = "";
		boolean isFound = false;

		System.out.print("Search Project \n Type project's name:  ");
		name = read(reader);
		isFound = controller.searchProjectSQA(name);

		if (isFound) {
			System.out.println("The " + name + "'s  project was found");
		} else {
			System.out.println("The " + name + "'s  project was NOT found");
		}
		return isFound;
	}

	/**
	 * Displays the URL of the published capsules
	 */
	public void publishCapsules() {

		System.out.println("Publish Capsules");
		boolean thereCapsule = false;
		boolean isNull = false;
		String show[][] = controller.showCapule(true);
		int option = 0;
		String url = "";
		for (int i = 0; i < show.length && !isNull; i++) {
			if (show[i][0] != null) {
				System.out.println(
						(i + 1) + "\t\3id " + show[i][2] + "\tProject: " + show[i][0] + "\tStage: " + show[i][1]);
				thereCapsule = true;// There are capsules to publish
			} else {
				isNull = true;
			}
		}
		if (thereCapsule) {
			do {
				System.out.println("Enter the number of the capsule you want to publish ");
				option = reader.nextInt();
				if (option != 0) {
					option -= 1;
					url = controller.publishCapsule(show[option][0], show[option][1], Integer.valueOf(show[option][3]),
							show[option][2]);
					System.out.println("Url" + url);
				}
			} while (option != 0);
		} else {
			System.out.println(" No exist capsule approved for publicate ");
		}
	}

	/**
	 * Control/View method that verifies if the input is a number, and can also be
	 * used to verify options with necessary restrictions.
	 * 
	 * @return The validated double value
	 */
	public double validateDouble() {
		double option = 0;
		do {
			if (reader.hasNextDouble()) {
				option = reader.nextDouble();
			} else {
				reader.next();// limpiar el scanner
				option = Integer.MAX_VALUE;
				System.out.print("Invalid number, type a number: ");
			}
		} while (option == Integer.MAX_VALUE);
		return option;
	}


	/**
	 * This function reads a non-empty line of input from a scanner object in Java.
	 * 
	 * @param scanner The scanner parameter is an object of the Scanner class that is used to read input
	 * from the user or from a file.
	 * @return The method is returning a String, which is the next non-empty line of text read from the
	 * Scanner object passed as a parameter.
	 */

	public String read(Scanner scanner) {
		String line = "";
		do {
			scanner.useDelimiter(System.lineSeparator());
			line = scanner.next();
			scanner.useDelimiter("\\p{javaWhitespace}+");
		} while (line.equalsIgnoreCase(""));
		return line;
	}

	/**
	 * This method shows that the stage has been approved, by instantiating a
	 * calendar variable to store the actual end date of the stage.
	 */

	public void approbationStage() {

		System.out.println("Stage approval");
		Calendar realEnd = Calendar.getInstance();
		System.out.println(controller.approbationStage(realEnd));
	}

	/**
	 * This view method registers the capsules to send them to the controller
	 * method and thus create the project's capsules of its current stage. The
	 * controller returns whether it was saved or not.
	 */

	public void registerCapsule() {

		String id = "", description = "", name = "", charge = "", learning = "";
		String[] hashtag = new String[20];
		double typeCapsule;


		System.out.print("Register " + controller.stageName(controller.counStage()) + " capsule  \n Type the Capsule id: ");
		id = reader.next();
		int free = 0;
		
			do {
				free = getFirstValidPosition(hashtag);
				System.out.print("Type the description id with word key(#such as#): ");
				description = read(reader);
				hashtag = capsuleHashtag(description, hashtag);
			} while (hashtag[free] == null);

		System.out.println("Capsule Type:\n1.Tecnic\n2.Manage\n3.Domain\n4.Experence");

			do {
				System.out.print("Enter the capsule type: ");
				typeCapsule = validateDouble();
			} while (typeCapsule != 1.0 && typeCapsule != 2.0 && typeCapsule != 3.0 && typeCapsule != 4.0);

		System.out.print("Enter the collaborator name: ");
		name = read(reader);
		System.out.print("Enter the collaborator charge: ");
		charge = read(reader);

			do {
				free = getFirstValidPosition(hashtag);
				System.out.print("Enter the lesson learned from the situation: ");
				learning = read(reader);
				hashtag = capsuleHashtag(learning, hashtag);
			} while (hashtag[free] == null);

		System.out.println(controller.addCapsule(id, description, (int) typeCapsule, name, charge, learning, hashtag));

	}

	/**
	 * This method searches for words or text strings that contain '#' and stores
	 * them in an array as keywords for each capsule, to subsequently use another
	 * method to search for them.
	 *
	 * At the moment it will only extract 10 capsules in description and lesson
	 * 
	 * @param description the variable that contains the text with the '#'
	 * @param wordKey     the array that will store the '#'
	 * @return the array with the found keywords
	 */
	
	public String[] capsuleHashtag(String description, String[] wordKey) {
		int finaL = 0, init = 0, contador = 0, pos = 0;
		for (int i = 0; i < description.length() && contador < 20; i++) {
			if (description.charAt(i) == '#') {
				contador++;
				if (contador % 2 == 0) {
					init = description.indexOf("#", finaL);
					finaL = description.indexOf("#", init + 1);
					
					if (finaL != (init + 1)) {//for verify that lest "##"
						pos = getFirstValidPosition(wordKey);
						wordKey[pos] = description.substring(init + 1, finaL);
						finaL += 2;
					}
				}
			}
		}
		return wordKey;
	}

	/**
	 * Finds the free position of an array
	 * 
	 * @param array Array to search for free space
	 * @return Returns the space if found, -1 otherwise.
	 */

	public int getFirstValidPosition(String[] array) {
		int pos = -1;
		
		boolean isFound = false;
		for (int i = 0; i < array.length && !isFound; i++) {
			if (array[i] == null) {
				pos = i;
				isFound = true;
			}
		}
		return pos;
	}



	/**
	 * This function displays a list of capsules awaiting approval and allows the user to approve them by
	 * entering their ID.
	 */

	public void capsuleApproval() {
		String show[][] = controller.showCapule(false);
		String id = "";
		boolean isNull = false;
		boolean thereCapsule = false;

		System.out.println("Capsule Aprobation \n");

		for (int i = 0; i < show.length && !isNull; i++) {
			if (show[i][0] != null) {
				System.out.println("\t\3id " + show[i][2] + "\tProject: " + show[i][0] + "\tStage: " + show[i][1]);
				thereCapsule = true;
			} else {
				isNull = true;
			}
		}

		if (thereCapsule) {

			do {
				System.out.print("Type the capsule's id (Exit=0): ");
				id = read(reader);
				if (!(id.equals("0"))) {
					System.out.println(controller.capsuleApproval(id));
				}
			} while (!(id.equals("0")));

		} else {
			System.out.println("There is no stage or they have already been approved");
		}

	}



	/**
	 * This function displays a menu of stages and prompts the user to select a stage to see the lessons
	 * related to that stage.
	 * 
	 * @param execution It is a parameter passed to the method, which is likely used to determine which
	 * execution of the lesson the user wants to see. However, without seeing the implementation of the
	 * "controller" object and the "lessonStage" method, it is difficult to determine the exact purpose of
	 * the "execution" parameter
	 */

	public void lessonStage(int execution) {
		double stage = 0;

		System.out.println("Stage's lesson: ");
		System.out.println("1.Start\n2.Analisys\n3.Desing\n4.Execution\n5.Clouse\n6.Monitoring and project control\n");
		do {
			System.out.print("Type the stage that you want to see the lessons: ");
			stage = validateDouble();
		} while (!(stage >= 1 && stage <= 6 && stage == Math.floor(stage)));

		System.out.println(controller.lessonStage((int) stage - 1, execution));
	}

	/**
	 * This Java function prints the project with the highest number of capsules using a controller
	 * method.
	 */

	public void moreAmountCapsule() {

		System.out.println("The project with more capsules is: ");
		System.out.println("\t+" + controller.moreAmountCapsule());
	}

	/**
	 * This Java function searches for a collaborator's capsule and prints the result.
	 */

	public void SearchColaboratorCapsule() {
		String collaborator = "";
		System.out.println("Search Collaborator");
		collaborator = read(reader);
		System.out.println(controller.searchCollaboratorCapsule(collaborator));
	}

	/**
	 * This Java function searches for capsules based on user input and prints the results.
	 */
	
	public void searchCapsule() {
		String text = "";
		System.out.println("Search Capsules");
		text = read(reader);
		System.out.println(controller.searchCapsule(text));
	}

}
