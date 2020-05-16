package book;

import java.util.Scanner;

import exception.PageException;

public interface Bookinput {

	public String getBookname();

	public void getUserInput(Scanner input);

	public void setBookname(String bookname);

	public void setAuthor(String author);

	public void setGenre(String genre);

	public void setPage(int page) throws PageException;

	public void setLaunch(String launch);

	public void printInfo();

	public void setBookname(Scanner input);

	public void setBookAuthor(Scanner input);

	public void setBookGenre(Scanner input);

	public void setBookPage(Scanner input);

	public void setBookLaunch(Scanner input);
}
