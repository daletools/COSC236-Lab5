package lab5.tests;

import static org.junit.jupiter.api.Assertions.*;

import lab5.PaperBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Library;
import lab5.Member;


class TestFindClassString {

	
private Library library;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.library = new Library(); // empty library for each test
	}
	
	Member member1 = new Member("Dude");
	Member member2 = new Member("Gal");
	PaperBook paperBook1 = new PaperBook("Dune");
	PaperBook paperBook2 = new PaperBook("1984");

	@Test
	void FindMember() {
		library.addMember(member1);
		library.addMember(member2);
		Member member = library.findMemberByName(member1.getName());
		assertEquals(member, member1, "Found member doesn't match");
		assertEquals(library.membersCount(), 2, "There should be two members");
		library.removeMember(member2);
		assertEquals(library.membersCount(), 1, "There should be only one member remain");
		member = library.findMemberByName(member2.getName());
		assertNull(member, "The mmber should not hav ben found after removal from the library");
		library.removeMember(member2);
		assertEquals(library.membersCount(),  1, "Removal of a non-existent member should not affect library");
		library.removeMember(member1);
		assertEquals(library.membersCount(), 0, "All members should have been removed");
	}

	@Test
	void FindBook() {
		library.addBook(paperBook1);
		library.addBook(paperBook2);
		PaperBook paperBook = library.findBookByTitle(paperBook1.getTitle());
		assert(paperBook == paperBook1);
		assert(library.booksCount() == 2);
		library.removeBook(paperBook2);
		assert(library.booksCount() == 1);
		paperBook = library.findBookByTitle(paperBook2.getTitle());
		assert(paperBook == null);
		library.removeBook(paperBook2);
		assert(library.booksCount() == 1);
		library.removeBook(paperBook1);
		assert(library.booksCount() == 0);
	}
}
