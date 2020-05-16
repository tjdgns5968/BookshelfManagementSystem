package book;

import java.util.Scanner;

public class KoreanliteratureBook extends PoetryBook {

	public KoreanliteratureBook(BookKind kind) {
		super(kind);
	}

	public void getUserInput(Scanner input) {
		setBookname(input);
		setBookAuthor(input);
		setBookGernewithYN(input);
		setBookPage(input);
	}
}
