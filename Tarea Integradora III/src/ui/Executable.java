package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller rXSystem;

	public Executable() {

		reader = new Scanner(System.in);
		rXSystem = new Controller();
	}

	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

    private void menu() {
		System.out.println("\n¡Bienvenido a ReadX!");
		System.out.println("1. Menu usuarios");
		System.out.println("2. Menu productos");
	
		int option = reader.nextInt();

		switch (option) {

			case 1:
				usersMenu();
			break;

			case 2:
				itemsMenu();
			break;

			default:
				System.out.println("Opción invalida");
			break;
		}
	}

    private void usersMenu() {

		boolean flag = false;

		while (!flag) {

            System.out.println("\nMenu usuarios");
			System.out.println("\n1. Registrar usuario");
			System.out.println("2. Modificar usuario");
			System.out.println("3. Borrar usuario");
			System.out.println("4. Consultar informacion de un usuario");
			System.out.println("5. Consultar informacion de todos los usuarios registrados");
			System.out.println("6. Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerUser();
				break;
			case 2:
				modifyUser();
				break;
			case 3:
				deleteUser();
				break;
			case 4:
				showUserInfo();
				break;
			case 5:
				showAllUserInfo();
				break;
			case 6:
				flag = true;
				break;
			default:
				System.out.println("Opcion invalida");
				break;
			}
		}
	}

    public void itemsMenu() {

		boolean flag = false;

		while (!flag) {

			System.out.println("\nMenu de items");
			System.out.println("\n1. Registrar item");
			System.out.println("2.Vender item");
			System.out.println("3.Consultar informacion registrada en el sistema");
			System.out.println("4.Salir");
			int option = reader.nextInt();

			switch (option) {

			case 1:
				registerItem();
				break;

			case 2:
				sellItem();
				break;

			case 3:
				showAllItemInfo();
				break;

			case 4:
				flag = true;
				break;

			}

		}

	}

    /**
 * This function registers a new user by prompting the user to input their personal information and
 * selecting their user type and premium category (if applicable), and then calls the registerUser
 * method from the rXSystem class to add the user to the system.
 */
	private void registerUser() {

		System.out.println("Digite a continuacion la informacion de un nuevo usuario");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite la cedula");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el nickname");
		String nickname = reader.nextLine();

		int userType = 0;
		int newCategory = 0;

		while(userType==0){

			System.out.println("Seleccione el tipo de usuario: \n 1.Regular \n 2.Premium ");
			userType = reader.nextInt();
			
			if (userType==2){
				System.out.println("Seleccione el tipo de premium: \n 1.Plata \n 2.Oro \n 3.Diamante");
				newCategory = reader.nextInt();
			}else{
				userType = 0;
				System.out.println("Opción invalida");
			}
		}

		if (rXSystem.registerUser(id, name, nickname,userType,newCategory)) {

			System.out.println("Usuario registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el Usuario");
		}
	}

/**
 * This function allows the user to modify the information of a registered user in the system.
 */
	private void modifyUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a editar");

			int option = reader.nextInt();

			int newCategory=0;
			String msg="";

			System.out.println("\nSeleccione la nueva categoria: \n 1.Nombre \n 2.Nickname \n 3.Categoria");
			int categoryC = reader.nextInt();

			if(categoryC==3){
				System.out.println("\nSeleccione el nuevo rango: \n 1.Estandar \n 2.Plata \n 3.Oro \n 4.Diamante");
				newCategory = reader.nextInt();
			}
			else{
			System.out.println("\nEscriba su nueva eleccion");
			reader.nextLine();
			msg = reader.nextLine();
			}

			if (rXSystem.editUser(option - 1,categoryC ,newCategory ,msg)) {

				System.out.println("\nUsuario editado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser editado");
			}

		}

	}

/**
 * This function deletes a user from the system after displaying a list of registered users and
 * prompting the user to select the user to be deleted.
 */
	private void deleteUser() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a borrar");

			int option = reader.nextInt();

			if (rXSystem.deleteUser(option - 1)) {

				System.out.println("\nUsuario borrado exitosamente");

			} else {

				System.out.println("\nError, el usuario no pudo ser borrado");
			}

		}

	}

/**
 * This function displays a list of registered users in the system and allows the user to select a user
 * to view their information.
 */
	private void showUserInfo() {

		String query = rXSystem.getUserList();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {

			System.out.println("\nEste es el listado de usuarios registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el usuario a consultar");

			int option = reader.nextInt();

			String query2 = rXSystem.getUserInfo(option-1);

			if (query2.equals("")) {
				System.out.println("La operación no pudo realizarse");
			} else {
				System.out.println(query2);
			}

		}

	}

/**
 * The function displays all user information registered in the system.
 */
	private void showAllUserInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getAllUserInfo();

		if (query.equals("")) {

			System.out.println("No hay usuarios registrados");
		} else {
			System.out.println(query);
		}

	}

	public void registerItem() {

		System.out.println("Digite a continuacion la informacion de un nuevo libro");

		// Limpieza de buffer
		reader.nextLine();

		System.out.println("Digite el identificador. Ej.: A1F");
		String id = reader.nextLine();

		System.out.println("Digite el nombre");
		String name = reader.nextLine();

		System.out.println("Digite el tipo de genero. \n1. Ciencia Ficcion \n2. Fantasia \n3. Novela historica");
		int genre = reader.nextInt();

		System.out.println("Digite el valor de venta");
		double price = reader.nextDouble();

		if (rXSystem.registerBook(id, name, genre, price)) {

			System.out.println("Libro registrado exitosamente");

		} else {

			System.out.println("Memoria llena, no se pudo registrar el libro");
		}
	}

	private void sellItem() {

		String query = rXSystem.getBookList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {

			System.out.println("\nEste es el lisatdo de libros registrados en el sistema");

			System.out.println(query);

			System.out.println("\nSeleccione el libro a vender");

			int option = reader.nextInt();

			// This line of code is checking if the item selected by the user (option - 1) can be sold by
			// calling the sellItem() method from the Controller class. If the sellItem() method returns true,
			// it means the transaction was successful and the message "Transaccion realizada exitosamente" is
			// printed. If the sellItem() method returns false, it means there was an error in the transaction
			// and the message "Error en la transaccion" is printed.

			if (rXSystem.sellBook(option - 1)) {

				System.out.println("\nTransaccion realizada exitosamente");

			} else {

				System.out.println("\nError en la transaccion");
			}

		}

	}

	public void showAllItemInfo() {

		System.out.println("Esta es la informacion registrada en el sistema");

		String query = rXSystem.getBookList();

		if (query.equals("")) {

			System.out.println("No hay libros registrados");
		} else {
			System.out.println(query);
		}

	}

}