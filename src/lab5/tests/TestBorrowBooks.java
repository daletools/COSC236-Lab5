package lab5.tests;

import lab5.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;

class TestBorrowBooks {

	Member member1;
	Member member2;

	PaperBook book1 = new PaperBook("Dune");
	PaperBook book2 = new PaperBook("1984");
	Book book3 = new EBook("Head First Design Patterns");
	Book book4 = new AudioBook("The Eye of the World");

	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice", BorrowingService.getInstance()); // flush borrowedBook array
		member2 = new Member("Bob", BorrowingService.getInstance()); // flush borrowedBook array
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
	}

	@Test
	void borrowBookBook() {

		// borrow first book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(book1.getIsAvailable(), "Book 1 must be available");
		member1.borrowBook(book1);
		assertFalse(book1.getIsAvailable(), "Book 1 must be not available");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of borrowed books must be 1");

		// borrow second book
		assertTrue(book2.getIsAvailable(), "Book must be available");
		member1.borrowBook(book2);
		assertFalse(book1.getIsAvailable(), "Book should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book count should be 2");
	}

	@Test
	void returnBookBook() {

		// borrow two books
		assertTrue(book1.getIsAvailable(), "Book 1 should be available");
		assertTrue(book2.getIsAvailable(), "Book 2 should be available");
		assertEquals(member1.borrowedBooksCount(), 0, "Member1 should not have any books");
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		assertEquals(member1.borrowedBooksCount(), 2, "The count of books must be 2");
		assertFalse(book1.getIsAvailable(), "Book 1 should not be available");
		assertFalse(book2.getIsAvailable(), "Book 2 should not be available");

		// return first book
		member1.returnBook(book1);
		assertTrue(book1.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");
		// return second book
		member1.returnBook(book2);
		assertTrue(book2.getIsAvailable(), "Book should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");

	}

	@Test
	void tooManyBorrowedBooks() {
		member1.borrowBook(book1);
		member1.borrowBook(book2);
		member1.borrowBook(book3);
		member1.borrowBook(book4);
		assertEquals(3, member1.borrowedBooksCount(), "Member should not be able to borrow more than 3 books.");
		assertTrue(book4.getIsAvailable(), "Book 4 should not have been marked unavailable.");
		member1.returnBook(book3);
		member1.borrowBook(book4);
		assertTrue(member1.getBorrowedBooks().contains(book4),
				"Member should be able to borrow after returning below the borrow limit.");
	}

}
