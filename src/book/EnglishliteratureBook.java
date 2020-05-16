package book;

import java.util.Scanner;

public class EnglishliteratureBook extends Book {

	public EnglishliteratureBook(BookKind kind) {
		super(kind);
	}

	public void getUserInput(Scanner input) {
		setBookname(input);
		setBookAuthor(input);
		setBookGenre(input);
		setBookPage(input);
		setBookLaunch(input);
	}

	public void printInfo() {
		String bkind = getKindString();
		System.out.println("kind:" + bkind + " Bookname: " + this.bookname + " //Author: " + this.author + " //Genre: " + this.genre + " //page: " + this.page + " //launch: " + this.launch);
	}
}
