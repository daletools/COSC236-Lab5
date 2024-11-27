package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.*;

public class BookFactoryTests {
	
	@Test
	void AddBooks() {
		LibrarianController lc = new LibrarianController();
		BookFactory paperFactory = new PaperBookFactory();
		BookFactory eFactory = new EBookFactory();
		BookFactory audioFactory = new AudioBookFactory();
		lc.addBook(paperFactory, "TestBook1");
		lc.addBook(eFactory, "TestBook2");
		lc.addBook(audioFactory, "TestBook3");
		
		assertTrue(lc.getLibrary().findBookByTitle("TestBook1") instanceof PaperBook);	
		assertTrue(lc.getLibrary().findBookByTitle("TestBook2") instanceof EBook);	
		assertTrue(lc.getLibrary().findBookByTitle("TestBook3") instanceof AudioBook);	

	}
}
