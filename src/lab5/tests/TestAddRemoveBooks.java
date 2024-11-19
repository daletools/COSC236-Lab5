package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import lab5.PaperBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lab5.Library;
import lab5.Member;



class TestAddRemoveBooks {
	
	private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}

	PaperBook paperBook1 = new PaperBook("Dune");
	PaperBook paperBook2 = new PaperBook("1984");
	PaperBook paperBook3 = new PaperBook("Moby Dick");
	
	Member member = new Member("Grady Booch");
	
	@Test
	void AddBooks() {
		
		assertEquals(library.booksCount(), 0, "Should be no books in library");	
		library.addBook(paperBook1);
		library.addBook(paperBook2);
		library.addBook(paperBook3);
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
	}
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook(paperBook2);
		library.removeBook(paperBook3);
		assertEquals(library.booksCount(), 1, "There should be only one book left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		library.removeBook("Dune");
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(library.booksCount(), 3, "There should be 3 books in the library");
		
		member.borrowBook(paperBook1);
		assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");
		
		library.removeBook(paperBook1);
		assertEquals(library.booksCount(), 2, "There should be only two book left in the library");
		
		assertEquals(member.borrowedBooksCount(), 1, "The book should stay with member"); // 
		
		PaperBook b = member.getBorrowedBooks().get(0); // the only book
		assertEquals(b, paperBook1,"The owned book should be the removed book");
	}
	
	
}
