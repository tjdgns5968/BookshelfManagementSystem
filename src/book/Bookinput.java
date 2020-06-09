package book;

import java.util.Scanner;

import exception.PageException;

public interface Bookinput {

	public String getBookname();

	public void getUserInput(Scanner input);

	public void setBookname(String bookname);
	
	public String getAuthor();

	public void setAuthor(String author);
	
	public String getGenre();

	public void setGenre(String genre);
	
	public String getPage();

	public void setPage(String page) throws PageException;
	
	public String getLaunch();

	public void setLaunch(String launch);

	public void printInfo();

	public void setBookname(Scanner input);

	public void setBookAuthor(Scanner input);

	public void setBookGenre(Scanner input);

	public void setBookPage(Scanner input);

	public void setBookLaunch(Scanner input);
}
