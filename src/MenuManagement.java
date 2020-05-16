import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BookManager bookManager = new BookManager(input);
		selectMenu(input, bookManager);
	}

	public static void selectMenu(Scanner input, BookManager bookManager) {		
		int num = -1; 
		while (num != 5) {
			try {
				showMenu();
				num = input.nextInt();
				switch(num) {
				case 1 :
					bookManager.addbook();
					break;
				case 2 :
					bookManager.deletebook();
					break;
				case 3 :
					bookManager.editbook();
					break;
				case 4 :
					bookManager.viewbooks();
					break;
				default:
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("**Please put an integer between 1 and 5!**");
				if (input.hasNext()) {
					input.next();
				}
				num = -1;						
			}
		}
	}

	public static void showMenu() {
		System.out.println("***Bookshelf Management System Menu***");
		System.out.println("1. Add book");
		System.out.println("2. Delete book");
		System.out.println("3. Edit book list");
		System.out.println("4. View book lists");
		System.out.println("5. Exit");
		System.out.print("Select one number between 1 - 5:");	
	}
}	


	
