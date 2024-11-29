package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	private BorrowingServiceAPI bS;

	public Member(String name, BorrowingService bS) {
		this.name = name;
		this.bS = bS;
		this.borrowedBooks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
  
	public BorrowingServiceAPI getBorrowingService() {

		return bS;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Member: " + name;
	}

	public void borrowBook(Book book) {
		BorrowingBookResult borrowingResult = bS.borrowBook(this, book);
		System.out.println("Success: " + borrowingResult.getIsSuccess() + ": " + borrowingResult.getBorrowingMessage());

	}

	public void returnBook(Book book) {
		BorrowingBookResult borrowingResult = bS.returnBook(this, book);
		System.out.println("Success: " + borrowingResult.getIsSuccess() + ": " + borrowingResult.getBorrowingMessage());
	}

	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}

	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}

	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
		while (bookIterator.hasNext()) {
			Book book = bookIterator.next();
			book.setIsAvailable(true);
		}
		borrowedBooks.clear(); // clear array of borrowed books
	}
}
