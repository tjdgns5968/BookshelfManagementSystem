package book;

import java.util.Scanner;

public class Etc extends PoetryBook {

	protected String similarGenre;
	protected String averagePage;
	protected String approximateLaunch;

	public Etc(BookKind kind) {
		super(kind);
	}

	public void getUserInput(Scanner input) {
		setBookname(input);
		setBookAuthor(input);
		setBookGernewithYN(input);
		setBooksimailarGernewithYN(input);
		setBookPage(input);
		setBookLaunch(input);
	}

	public void setBooksimailarGernewithYN(Scanner input) {
		char answer = 'x';
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') {
			System.out.print("Can you define a genre? (Y/N)");
			answer = input.next().charAt(0);
			if(answer == 'y' || answer == 'Y' ) {
				setBookGenre(input);
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

	public void printInfo() {
		String bkind = getKindString();
		System.out.println("kind:" + bkind + " Bookname: " + this.bookname + " //Author: " + this.author + " //Genre: " + this.genre + " //Page: " + this.page + " //launch: " + this.launch + " // simailar Genre: " + this.genre + " //averagePage: " + this.page + " //approximateLaunch: " + this.launch);
	}
}
