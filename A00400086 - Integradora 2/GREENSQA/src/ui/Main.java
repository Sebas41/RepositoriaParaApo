import java.util.Scanner;
//// La clase Main va a ser nuestra Vista. Solo esta clase, puede usar el metodo public static void main(String[] args)

import model.GreenSQA;

public class Main {

   //Controlador
   private GreenSQA controller = new GreenSQA();
   private Scanner lector = new Scanner(System.in);


   public static void main(String args[]) {
      Main main = new Main();
      main.menu();
   }

   public void menu() {
      int counter = 0;
      while (counter != 1) {
         System.out.println("----------------------------------");
         System.out.println("              GREENSQA           ");
         System.out.println("----------------------------------");

         System.out.println("Select the option ");
         System.out.println("1. Create a project ");
         System.out.println("2. Complete project stage");
         System.out.println("3. Regiser Capsule");
         System.out.println("4. Approve capsule");
         System.out.println("5. Publish capsule");
         System.out.println("11. exit");
         System.out.println("----------------------------------");
         int option = lector.nextInt();
         lector.nextLine();

         switch (option) {
            case 1:
               createProject();
               break;

            case 2:

               break;

            case 3:
               String id;
               String description;
               String typeCapsule;
               String nameCollaborator;
               String cargoCollaborator;
               String learning;

               System.out.println("----------------------------------");
               System.out.println("Enter the id of the capsule");
               id = lector.nextLine();
               System.out.println("Enter a short description for the capsule ");
               description = lector.nextLine();
               System.out.println("Enter the type for the capsule");
               typeCapsule = lector.nextLine();
               System.out.println("Cual es el nombre del colaborador ");
               nameCollaborator = lector.nextLine();
               System.out.println("enter the position of the collaborator ");
               cargoCollaborator = lector.nextLine();
               System.out.println("Type Capsule Learning ");
               learning = lector.nextLine();
               break;

            case 4:

               break;

            case 5:

               break;

            case 11:
               counter = 1;
               System.out.println("Thank you for using the program");
               break;

            default:
               System.out.println("Error");
               break;
         }
      }
   }

   public void createProject(){
      String nameProject;
      String nameClient;
      String dateStart;
      String dateEnd;
      double budget;
      String nameManager;
      int cellManager;

      System.out.println("----------------------------------");
      System.out.println("What is the name of the project? ");
      nameProject = lector.nextLine();
      System.out.println("What is the customer's name? ");
      nameClient = lector.nextLine();
      System.out.println("What is the start date? DD/MM/YY ");
      dateStart = lector.nextLine();
      System.out.println("What is the planned end date? DD/MM/YY ");
      dateEnd = lector.nextLine();
      System.out.println("What is the budget for the project? ");
      budget = lector.nextDouble();
      lector.nextLine();
      System.out.println("What is the name of the manager? ");
      nameManager = lector.nextLine();
      System.out.println("What is the manager's phone number? ");
      cellManager = Integer.parseInt(lector.nextLine());
      String[] datesIn = new String[6];
      String[] datesEnd = new String[6];
      for(int i = 0; i<datesEnd.length; i++){
         System.out.println("What is the planned start date in the stage " + (i+1) + "?");
         datesIn[i] = lector.nextLine();
         System.out.println("What is the planned end date in the stage " + (i+1) + "?");
         datesEnd[i] = lector.nextLine();
      }
      // Aqui usamos el controller
      System.out.println(controller.createProject(nameProject, nameClient, dateStart, dateEnd, budget, nameManager, cellManager, datesIn, datesEnd));      
   }
}