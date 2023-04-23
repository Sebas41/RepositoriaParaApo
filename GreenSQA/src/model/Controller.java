package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class is in charge of controlling the functions of each class called
 * from the administration class
 */

public class Controller {

    private final int SIZE = 10;
    private ProjectSQA[] projectSQA = new ProjectSQA[SIZE];
    private ProjectSQA currentProject;
    private int amoProject = 0;
    private SimpleDateFormat view = new SimpleDateFormat("dd/MM/yyyy 'hours: ' hh:mm:ss a");
    private String url[] = new String[3000];
    private int accountUrl = 0;

    public Controller() {
    }



    /**
     * The function registers a new project with a given name, start date, and budget, and returns a
     * message indicating whether the registration was successful or not.
     * 
     * @param name A String representing the name of the project to be registered.
     * @param startDate startDate is a Calendar object that represents the start date of the project being
     * registered. It is used in the method to create a new ProjectSQA object with the given name, start
     * date, and budget.
     * @param budget The budget is a double data type and represents the amount of money allocated for the
     * project.
     * @return The method is returning a String message indicating whether the project was registered
     * successfully or not.
     */

    public String registerProject(String name, Calendar startDate, double budget) {
        String register = "The project was not register succesfully, no space to register\n";

        if (amoProject != projectSQA.length) {

            projectSQA[amoProject] = new ProjectSQA(name, startDate, budget);
            register = "The project was register succesfully\n";
            currentProject = projectSQA[amoProject];
            amoProject++;
        }
        return register;
    }

    /**
     * Register the client or manager in a project
     * 
     * @param name
     * @param phone
     * @param typePerson
     * @return
     */

    public String registerPerson(String name, String phone, String typePerson) {
        return currentProject.registerPerson(name, phone, typePerson);
    }

    /**
     * Assigns the dates of the projects, according to the number of months
     * registered, and with a method of the same name assigns the final and initial
     * dates of this
     * 
     * @param month
     * @return a message if the dates were correctly assigned
     */

    public String assingDate(int[] month) {
        return currentProject.assingDate(month);
    }

    /**
     * This method is in charge of searching for a project with the entered name, if
     * it finds it, it will store it in the currentProject object, this has the
     * objective of making two objects with mutual modification from one
     * 
     * @param name name of the project to search for
     * @return true: found, false: not found
     */

    public boolean searchProjectSQA(String name) {
        
        boolean isFound = false;

        for (int i = 0; i < amoProject && !isFound; i++) {
            if (name.equalsIgnoreCase(projectSQA[i].getName())) {
                isFound = true;
                currentProject = projectSQA[i];
            }
        }
        return isFound;
    }


    /**
     * This function adds a capsule to the current project's stage with the given parameters.
     * 
     * @param id A String representing the unique identifier of the capsule being added.
     * @param description A String representing the description of the capsule being added.
     * @param type An integer representing the type of capsule being added. The possible values are:
     * @param nameCollaborator The name of the collaborator who created the capsule.
     * @param charge It is a String parameter that represents the charge or role of the collaborator who
     * created the capsule.
     * @param learning A string representing the learning objectives of the capsule.
     * @param hashtag An array of strings representing the hashtags associated with the capsule being
     * added.
     * @return The method is returning a String message. The content of the message depends on the
     * execution of the method and the values of the input parameters.
     */
    
    public String addCapsule(String id, String description, int type, String nameCollaborator, String charge,
            
        String learning, String[] hashtag) {
        String msg = "";

        if (currentProject != null) {

            TypeCapsule typeCapsule = null;

            switch (type) {

                case 1:
                typeCapsule = TypeCapsule.Tecnic;
                break;

                case 2:
                typeCapsule = TypeCapsule.Manage;
                break;

                case 3:
                typeCapsule = TypeCapsule.Domain;
                break;

                case 4:
                typeCapsule = TypeCapsule.Experience;
                break;
            }

            Capsule capsule = new Capsule(id, description, typeCapsule, nameCollaborator, charge, learning, hashtag);
            msg = currentProject.getStage(currentProject.counStage()).addCapsule(capsule);
        }

        return msg;
    }

    /**
     * Method to approve the capsules from their id
     * 
     * @param id
     * @return if the capsule exists, it was approved, otherwise
     */

    public String capsuleApproval(String id) {

        String project, stage;
        String capsule = "The calpsule with its " + id + " not exist";
        boolean isFound = false;
        Calendar aprobationDate = Calendar.getInstance();

        for (int i = 0; i < amoProject && !isFound; i++) {

            for (int j = 0; j < 6 && !isFound; j++) {

                if (projectSQA[i] != null) {

                    isFound = projectSQA[i].getStage(j).capsuleApproval(id, aprobationDate);

                    if (isFound) {

                        project = projectSQA[i].getName();
                        stage = projectSQA[i].getStage(i).getType();
                        capsule = "The calpsule " + id + " from " + stage + "'s stage of the" + project
                                + " project was approved. Date: " + view.format(aprobationDate.getTime());
                    }
                }
            }
        }

        return capsule;
    }

    /**
     * Displays the name of a project stage.
     * 
     * @param i: Position of a stage within a project.
     * @return The name of the stage being searched for.
     */

    public String stageName(int i) {
        return currentProject.getStage(i).getType();
    }

    /**
     * @return The name of the current project being worked on.
     */

    public String projectName() {
        return currentProject.getName();
    }

    /**
     * @return The position of the current stage being worked on within a project.
     */

    public int counStage() {
        return currentProject.counStage();
    }

    /**
     * Approves a project stage by calling a method of the Project class to approve
     * a stage and saves the real end date of that stage.
     * 
     * @param realEnd The final date on which the stage was completed.
     * @return Whether the stage was approved or if no more stages can be approved.
     */

    public String approbationStage(Calendar realEnd) {
        return currentProject.approbationStage(realEnd);
    }

    /**
     * URL for publishing approved capsules related to organizational interests.
     * 
     * @return The URL for the published capsules.
     */

    public String publishCapsule(String project, String stage, int posStage, String idCapsule) {

        String url = "";
        searchProjectSQA(project);
        currentProject.getStage(posStage).searchCapsule(idCapsule).setPublish(true);
        url = "https://www.capsulas/capsula/" + idCapsule + "/project:" + project + "/stage:" + stage + ".com";
        this.url[accountUrl++] = url;
        return url;
    }

    /**
     * The function returns a 2D array of information about unpublished capsules in approved or unapproved
     * stages of projects.
     * 
     * @param aprobation A boolean value indicating whether to show capsules that have been approved or not
     * approved. If aprobation is true, only approved capsules will be shown. If aprobation is false, only
     * capsules that have not been approved will be shown.
     * @return The method is returning a 2D array of Strings called `msg`. Each row of the array represents
     * a capsule that meets the specified conditions (approved or not approved) and has not been published
     * yet. The columns of the array represent the project name, stage type, capsule ID, and stage number.
     */

    public String[][] showCapule(boolean aprobation) {
        String msg[][] = new String[100][4];
        int l = 0;
        for (int i = 0; i < amoProject; i++) {

            for (int j = 0; j <= projectSQA[i].counStage(); j++) {
                
                for (int j2 = 0; j2 < 50; j2++) {

                    if (projectSQA[i].getStage(j).getCapsule(j2) != null && projectSQA[i].getStage(j).getCapsule(j2).getAprobation() == aprobation) {

                        if (projectSQA[i].getStage(j).getCapsule(j2).getPublish() == false) {
                            
                            msg[l][0] = projectSQA[i].getName();
                            msg[l][1] = projectSQA[i].getStage(j).getType();
                            msg[l][2] = projectSQA[i].getStage(j).getCapsule(j2).getId();
                            msg[l][3] = String.valueOf(j);

                            l++;
                        }
                    }
                }
            }
        }

        return msg;
    }

    /**
     * This view method returns the number of capsules according to their type,
     * there are two cases divided into two options using conditionals. Either for
     * all the projects (1) that uses a reference object for each of the objects or
     * for a current project that the user is in (2), which does not go through the
     * project cycle, only the stages
     * 
     * @param option the option 1 or 2.It's already burned in the Administration
     *               system
     * @return Message showing the amount for each type of capsule
     */

    public String amountType(int option) {

        int technical = 0, management = 0, domainSpecific = 0, experience = 0;
        boolean finish = false;
        String msg = "\n\3Capsule Type Amount:\3 ";

        for (int i = 0; i < amoProject && !finish; i++) {

            if (option == 1) {
                currentProject = projectSQA[i];
            }

            for (int j = 0; j <= currentProject.counStage(); j++) {

                technical += currentProject.getStage(j).amountTypeCap("Technical");
                management += currentProject.getStage(j).amountTypeCap("Management");
                domainSpecific += currentProject.getStage(j).amountTypeCap("Domain-specific");
                experience += currentProject.getStage(j).amountTypeCap("Experience-based");

            }

            if (option == 2) {
                finish = true;
            }
        }
        msg += "\n -Amount Technical: " + technical + "\n -Amount Management: " + management +
                "\n -Amount Domain-specific: " + domainSpecific + "\n -Amount Experience-based: " + experience;

        return msg;
    }



    /**
     * The function returns a string message containing the lesson stage of a project, based on the given
     * stage and execution parameters.
     * 
     * @param stage an integer representing the stage of a lesson in a project
     * @param execution The execution parameter is an integer that determines whether to execute the entire
     * lesson or just the first stage. If execution is 1, it will execute the entire lesson starting from
     * the specified stage. If execution is 2, it will only execute the first stage and stop.
     * @return The method `lessonStage` returns a `String` message that represents the lesson stage of a
     * project. The `lessonStage` method is called for each project in the `projectSQA` array, and the
     * messages are concatenated into a single `String` variable `msg`. If there are no projects in the
     * `projectSQA` array, the method returns a message indicating that there are no
     */

    public String lessonStage(int stage, int execution) {
        String msg = "";
        boolean finish = false;
        for (int i = 0; i < amoProject && !finish; i++) {

            if (execution == 1) {
                currentProject = projectSQA[i];
            }
            msg += currentProject.lessonStage(stage);

            if (execution == 2) {
                finish = true;
            }
        }
        if (projectSQA[0] == null) {
            msg = "There are no projects";
        }
        return msg;
    }



    /**
     * The function returns the name and number of capsules of the project with the highest capsule count
     * among all projects.
     * 
     * @return The method `moreAmountCapsule()` returns a String message that indicates the project with
     * the highest number of capsules and the number of capsules it has. If there are no projects, it
     * returns a message indicating that there are no projects.
     */

    public String moreAmountCapsule() {
        String msg = "";
        int maxium = -1;
        String project = "";

        for (int i = 0; i < amoProject; i++) {
            if (projectSQA[i].capsuleCounter() > maxium) {
                maxium = projectSQA[i].capsuleCounter();
                project = projectSQA[i].getName();
            }
        }
        msg = project + " - N#: " + maxium;
        if (projectSQA[0] == null) {
            msg = "There are no projects";
        }

        return msg;
    }


    /**
     * This Java function searches for a collaborator's capsule in a project management system and returns
     * a message indicating the project, stage, and capsule ID if found, or a message indicating that the
     * collaborator was not found or there are no projects.
     * 
     * @param collaborator A String representing the name of the collaborator being searched for in the
     * capsules.
     * @return The method is returning a String message that indicates the project, stage, and capsule
     * where a collaborator is registered, or a message indicating that the collaborator was not found or
     * there are no projects.
     */

    public String searchCollaboratorCapsule(String collaborator) {
        
        String msg = "";

        for (int i = 0; i < amoProject; i++) {

            for (int j = 0; j <= projectSQA[i].counStage(); j++) {

                for (int j2 = 0; j2 < projectSQA[i].getStage(j).getCapCouter(); j2++) {

                    if (projectSQA[i].getStage(j).getCapsule(j2).getCollaborator().equalsIgnoreCase(msg)) {

                        String project = projectSQA[i].getName();
                        String stage = projectSQA[i].getStage(j).getType();
                        String capsule = projectSQA[i].getStage(j).getCapsule(j2).getId();
                        msg = "The collaborator " + collaborator + " registered in the:\n\t-Project: " + project;
                        msg += "\n\t-Stage: " + stage + "\n\t-Idcapsule: " + capsule;
                    }
                }

            }

        }

        if (msg.equals("")) {
            msg = "The collaborator was not found or no exist";
        }
        if (projectSQA[0] == null) {
            msg = "There are no projects";
        }
        return msg;
    }

    /**
     * The function searches for capsules in projects based on a given text and returns a message
     * indicating whether any capsules were found or not.
     * 
     * @param text The search text that the user wants to look for in the capsules.
     * @return A string message that contains the capsules that match the search text, or a message
     * indicating that there are no capsules with the search text or no projects.
     */
    
    public String searchCapsule(String text) {
        StringBuilder msg = new StringBuilder();
        String[] searchWord = text.split(" ");
        boolean isFound;

        for (int i = 0; i < amoProject; i++) {
            
            for (int j = 0; j <= projectSQA[i].counStage(); j++) {

                for (int j2 = 0; j2 < projectSQA[i].getStage(j).getCapCouter(); j2++) {
                    isFound = false;
                    String[] hashtag = projectSQA[i].getStage(j).getCapsule(j2).getHashtag();
                    for (int k = 0; k < hashtag.length && !isFound; k++) {

                        for (int l = 0; l < searchWord.length && !isFound; l++) {
                            if (hashtag[k].equalsIgnoreCase(searchWord[l])) {
                                isFound = true;
                                msg.append(projectSQA[i].getStage(j).getCapsule(i).toString());
                            }
                        } 
                    } 
                } 
            } 
        } 

        if (msg.length() == 0) {
            msg.append("There are not capsules with its search text");
        }
        if (projectSQA[0] == null) {
            msg.append("There are no projects");
        }
        return msg.toString();
    }

}
