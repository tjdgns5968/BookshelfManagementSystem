import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import book.Book;
import book.BookKind;
import book.Bookinput;
import book.EnglishliteratureBook;
import book.Etc;
import book.KoreanliteratureBook;

public class BookManager {
	ArrayList<Bookinput> books = new ArrayList<Bookinput>();
	Scanner input; 
	BookManager(Scanner input) {
		this.input = input;
	}

	public void addbook() {
		int kind =0;
		Bookinput bookinput;
		while (kind != 1 && kind != 2) {
			try {
				System.out.println("1 for Englishliterature");
				System.out.println("2 for Koreanliterature");
				System.out.println("3 for Etc");
				System.out.print("Select num 1,2, or 3 for Book Kind:");
				kind = input.nextInt();
				if (kind == 1) {
					bookinput = new EnglishliteratureBook(BookKind.Englishliterature);
					bookinput.getUserInput(input);
					books.add(bookinput);
					break;
				}
				else if(kind == 2) {
					bookinput = new KoreanliteratureBook(BookKind.Koreanliterature);
					bookinput.getUserInput(input);
					books.add(bookinput);
					break;
				}
				else if(kind == 3) {
					bookinput = new Etc(BookKind.etc);
					bookinput.getUserInput(input);
					books.add(bookinput);
					break;
				}
				else {
					System.out.print("Select num for Book Kind between 1 and 2:");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Please put an integer between 1 and 3!");
				if (input.hasNext()) {
					input.next();
				}
				kind = -1;
			}
		}
	}

	public void deletebook() {
		System.out.print("Book Name:");
		String bookname = input.next();
		int index = findIndex(bookname);
		removefromBooks(index, bookname);
	}

	public int findIndex(String bookname) {
		int index = -1;
		for (int i = 0 ; i < books.size() ; i++) {
			if (books.get(i).getBookname().equals(bookname)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int removefromBooks(int index, String bookname) {
		if(index >= 0) {
			books.remove(index);
			System.out.println("the book " + bookname + " is deleted");
			return 1;
		}
		else {
			System.out.println("the book has not been registered");
			return -1;
		}
	}

	public void editbook() {
		System.out.print("Book Name:");
		String bookname = input.next();
		for (int i = 0 ; i < books.size(); i++) {
			Bookinput book = books.get(i);
			if (book.getBookname().equals(bookname)) {
				int num = -1; 
				while (num != 6) {
					showEditMenu();
					num = input.nextInt();
					switch(num)
					{
					case 1:
						book.setBookname(input);
						break;
					case 2:
						book.setBookAuthor(input);
						break;
					case 3:
						book.setBookGenre(input);
						break;
					case 4:
						book.setBookPage(input);
						break;
					case 5:
						book.setBookLaunch(input);
						break;
					default:
						continue;
					}				
				} 
				break;
			} 
		}	
	}

	public void viewbooks() {
		System.out.println("# of registered books: " + books.size());
		for (int i = 0 ; i < books.size() ; i++) {
			books.get(i).printInfo();
		}
	}

	public void showEditMenu() {
		System.out.println("** Book Info Edit Menu**");
		System.out.println("1. Edit Bookname");
		System.out.println("2. Edit Author of Book");
		System.out.println("3. Edit Genre of Book");
		System.out.println("4. Edit Page of Book");
		System.out.println("5. Edit launch date of Book");
		System.out.println("6. Exit");
		System.out.print("Select one number between 1 - 6:");
	}
}
