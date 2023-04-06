package model;
public class GreenSQA {

    private Project[] projects;

    public GreenSQA(){
        projects= new Project [10];
    }

    public String createProject(String nameProject, String nameClient, String dateStart, String dateEnd, double budget, String nameManager, int pManager, String[] dIn, String[] dEnd){
        String menssage="";
        boolean flag = false;
        String[] x = dateStart.split("/"); 
        String[] y = dateEnd.split("/");
        Project obj = new Project(nameProject, nameClient, new Date(Integer.valueOf(x[0]), Integer.valueOf(x[1]), Integer.valueOf(x[2])),new Date(Integer.valueOf(y[0]), Integer.valueOf(y[1]), Integer.valueOf(y[2])), budget, nameManager, pManager);
        boolean existe = validateC(obj);
        if (existe){
            menssage = "el proyecto ya existe";
        }
        else{
            for(int i=0; i<projects.length && flag == false; i++ ){
                if (projects[i] == null ){
                    projects[i] = obj;
                    createStage(obj, dIn, dEnd);
                    flag = true;
                }
            }

            if (flag == true){
                menssage = "Registered.";
            } else {
                menssage= "No registration, because The list is full";
            }
       }
       return menssage;
    }

    public boolean validateC(Project newProject){
        for(int i=0; i<projects.length; i++ ){
            if(projects[i] != null && projects[i].getNameProject().equalsIgnoreCase(newProject.getNameProject())){
                return true;
            }
        }
        return false;
    }               
    public void createStage(Project projectName, String[] dateIn, String[] dateEnd){
        for(int i = 0; i<TypeStage.values().length; i++){
            String[] x = dateIn[i].split("/");
            String[] y = dateEnd[i].split("/");
            DateStage date = new DateStage(new Date(Integer.valueOf(x[0]), Integer.valueOf(x[1]), Integer.valueOf(x[2])), new Date(Integer.valueOf(y[0]), Integer.valueOf(y[1]), Integer.valueOf(y[2])));
            projectName.getStages()[i] = new Stage(TypeStage.values()[i], date);
        }              
    }



}
