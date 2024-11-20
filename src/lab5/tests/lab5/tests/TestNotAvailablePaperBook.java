package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.PaperBook;
import lab5.Member;

class TestNotAvailablePaperBook {

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
	void tryToBorrowBookBook() {
		
		// first member borrows a book
		
		assertEquals(member1.borrowedBooksCount(), 0, "Borrowed books should be zero");
		assertEquals(member2.borrowedBooksCount(), 0, "Borrowed books should be zero");
		
		assertTrue(paperBook1.getIsAvailable(), "PaperBook should be available");
		member1.borrowBook(paperBook1);
		assertFalse(paperBook1.getIsAvailable(), "PaperBook should be borrowed");
		assertEquals(member1.borrowedBooksCount(), 1, "Count of borrowed books must be 1");
		
		// second member borrows the same book 
		member2.borrowBook(paperBook1);
		assertFalse(paperBook1.getIsAvailable(), "PaperBook should still be borrowed" );
		assertEquals(member1.borrowedBooksCount(), 1, "Member should have one book");
		assertEquals(member2.borrowedBooksCount(), 0, "Member should have no books after rejection");
		
		// first member returns the book 
		member1.returnBook(paperBook1);
		assertTrue(paperBook1.getIsAvailable(), "PaperBook should be available after return");
		
		// second member borrows the same book 
		member2.borrowBook(paperBook1);
		
		assertFalse(paperBook1.getIsAvailable(), "PaperBook should be borrowed");
		assertEquals(member1.borrowedBooksCount(), 0, "Member should have no borrowed books");
		assertEquals(member2.borrowedBooksCount(), 1, "Member should have one book");
		
			
	}

}
