package book;

import java.util.Scanner;

public  abstract class PoetryBook extends Book {

	public PoetryBook(BookKind kind) {
		super(kind);
	}

	@Override
	public abstract void getUserInput(Scanner input);

	@Override
	public void printInfo() {
		String bkind = getKindString();
		System.out.println("kind:" + bkind + " Bookname: " + this.bookname + " //Author: " + this.author + " //Genre: " + this.genre + " //page: " + this.page + " //launch: " + this.launch);
	}
	public void setBookGernewithYN(Scanner input) {
		char answer = 'x';
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N')
		{
			System.out.print("Can you define a genre? (Y/N)");
			answer = input.next().charAt(0);
			if(answer == 'y' || answer == 'Y' ) {
				System.out.print("Genre of Book:");
				String genre = input.next();
				this.setGenre(genre);
				break;
			}
			else if (answer == 'n' || answer == 'N' ) {
				this.setGenre("");
				break;
			}
			else {
			}
		}
	}
}



