package book;

import java.util.Scanner;
import exception.PageException;

public abstract class Book implements Bookinput {
	protected BookKind kind = BookKind.Englishliterature;
	protected String bookname;
	protected String author;
	protected String genre;
	protected String page;
	protected String launch;

	public Book() {
	}

	public Book(BookKind kind) {
		this.kind = kind;
	}

	public Book (String bookname, String author, String genre) {
		this.bookname = bookname;
		this.author = author;
		this.genre = genre;
	}

	public Book (String bookname, String author, String genre, String page, String launch) {
		this.bookname = bookname;
		this.author = author;
		this.genre = genre;
		this.page = page;
		this.launch = launch;
	}

	public Book (BookKind kind ,String bookname, String author, String genre, String page, String launch) {
		this.kind = kind;
		this.bookname = bookname;
		this.author = author;
		this.genre = genre;
		this.page = page;
		this.launch = launch;
	}

	public BookKind getKind() {
		return kind;
	}

	public void setKind(BookKind kind) {
		this.kind = kind;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) throws PageException {
		if(!page.contains("ÂÊ")) {
			throw new PageException(); 
		}
		this.page = page;
	}

	public String getLaunch() {
		return launch;
	}

	public void setLaunch(String launch) {
		this.launch = launch;
	}

	public abstract void printInfo();

	public void setBookname(Scanner input) {
		System.out.print("Edit Book Name:");
		String Bookname = input.next();
		this.setBookname(Bookname);
	}

	public void setBookAuthor(Scanner input) {
		System.out.print("Edit Author of Book:");
		String author = input.next();
		this.setAuthor(author);
	}

	public void setBookGenre(Scanner input) {
		System.out.print("Edit Genre of Book:");
		String genre = input.next();
		this.setGenre(genre);
	}

	public void setBookPage(Scanner input) {
		String page = "";
		while (!page.contains("ÂÊ")) {
			System.out.print("Edit Page of Book:");
			page = input.next();
			try {
				this.setPage(page);
			} catch (PageException e) {
				System.out.println("**Incorrect Page Format. Please put the sign 'ÂÊ' in it. **");
			}
		}
	}

	public void setBookLaunch(Scanner input) {
		System.out.print("Edit launch date of Book:");
		String launch = input.next();
		this.setLaunch(launch);	
	}

	public String getKindString() {
		String bkind = "none";
		switch(this.kind) {
		case Englishliterature:
			bkind = "English.";
			break;
		case Koreanliterature:
			bkind = " Korean.";
			break;
		case Japaneseliterature:
			bkind = " Japanese.";
			break;
		case etc:
			bkind = " etc.";
			break;
		default: 
		}
		return bkind;
	}
}
