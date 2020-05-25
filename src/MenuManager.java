import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import log.EventLogger;

public class MenuManager {
	static EventLogger logger = new EventLogger("log.txt");

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		BookManager bookManager = getObject("bookmanager.ser");
		if (bookManager == null) {
			bookManager = new BookManager(input);
		}
		else {
			bookManager.setScanner(input);
		}

		selectMenu(input, bookManager);
		putObject(bookManager, "bookmanager.ser");
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
					logger.log("add a book");
					break;
				case 2 :
					bookManager.deletebook();
					logger.log("delete a book");
					break;
				case 3 :
					bookManager.editbook();
					logger.log("edit a book");
					break;
				case 4 :
					bookManager.viewbooks();
					logger.log("edit a list of book");
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
		System.out.println("Select one number between 1 - 5:");	
	}

	public static BookManager getObject(String filename) {
		BookManager bookManager = null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			bookManager = (BookManager)in.readObject();

			in.close();
			file.close();
		} catch (FileNotFoundException e) {
			return bookManager; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookManager;
	}

	public static void putObject(BookManager bookManager , String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(bookManager);

			out.close();
			file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	



