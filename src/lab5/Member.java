package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<PaperBook> borrowedPaperBooks; // PaperBook class dependency
	
	public Member(String name) {
		this.name = name;
		this.borrowedPaperBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<PaperBook> getBorrowedBooks() {
		return borrowedPaperBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(PaperBook paperBook) {
		if (paperBook != null && paperBook.getIsAvailable() == true) {
			borrowedPaperBooks.add(paperBook);
			paperBook.setIsAvailable(false);
		}
	}
	public void returnBook(PaperBook paperBook) {
		if (paperBook != null) {
			borrowedPaperBooks.remove(paperBook);
			paperBook.setIsAvailable(true);
		}
	}
	public void listBorrowedBooks() {
		for (PaperBook paperBook : borrowedPaperBooks)
			System.out.println(paperBook); // paperBook.toString()
	}
	public int borrowedBooksCount() {
		return borrowedPaperBooks.size();
	}
	public void returnAllBooks() {
		Iterator<PaperBook> bookIterator = borrowedPaperBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 PaperBook paperBook = bookIterator.next();
		   	 paperBook.setIsAvailable(true);
	    }
	    borrowedPaperBooks.clear(); // clear array of borrowed books
	}
}
