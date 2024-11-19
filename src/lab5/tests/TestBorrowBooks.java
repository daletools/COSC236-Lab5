package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.PaperBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Member;

class TestBorrowBooks {

	Member member1;
	Member member2;
	
	PaperBook paperBook1 = new PaperBook("Dune");
	PaperBook paperBook2 = new PaperBook("1984");
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Alice"); // flush borrowedBook array 
		member2 = new Member("Bob");   // flush borrowedBook array 
		paperBook1.setIsAvailable(true);
		paperBook2.setIsAvailable(true);
	}
	@Test
	void borrowBookBook() {
		
		// borrow first book
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		assertTrue(paperBook1.getIsAvailable(), "PaperBook 1 must be available");
		member1.borrowBook(paperBook1);
		assertFalse(paperBook1.getIsAvailable(),"PaperBook 1 must be not available");
		assertEquals(member1.borrowedBooksCount(),1, "Count of borrowed books must be 1");
		
		// borrow second book
		assertTrue(paperBook2.getIsAvailable(),"PaperBook must be available");
		member1.borrowBook(paperBook2);
		assertFalse(paperBook1.getIsAvailable(), "PaperBook should not be available");
		assertEquals(member1.borrowedBooksCount(), 2, "The book coubnt shoud be 2");
	}
	
	@Test
	void returnBookBook() {
		
		// borrow two books
		assertTrue(paperBook1.getIsAvailable(), "PaperBook 1 should be available");
		assertTrue(paperBook2.getIsAvailable(), "PaperBook 2 should be available");
		assertEquals(member1.borrowedBooksCount(), 0,"Member1 should not have any books" );
		member1.borrowBook(paperBook1);
		member1.borrowBook(paperBook2);
		assertEquals(member1.borrowedBooksCount(),2, "The count of books must be 2");
		assertFalse(paperBook1.getIsAvailable(), "PaperBook 1 should not be available");
		assertFalse(paperBook2.getIsAvailable(), "PaperBook 2 should not be available");
		
		// return first book
		member1.returnBook(paperBook1);
		assertTrue(paperBook1.getIsAvailable(), "PaperBook should be available after return");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of books must be 1");
		// return second book
		member1.returnBook(paperBook2);
		assertTrue(paperBook2.getIsAvailable(), "PaperBook should be available after return");
		assertEquals(member1.borrowedBooksCount(), 0, "Member 1 should have no books");
		
	}

}
