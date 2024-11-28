package lab5;

public class LibraryApp {

	// Create Controller, It will create an empty Library
	private static LibrarianController librarian = new LibrarianController();

	// Some functions for the Assignment
	private static void addMember(String name) {
		librarian.addMember(name);
	}

	// code changes
	private static void addPaperBook(String title) {
		librarian.addPaperBook(title);
	}

	private static void addEBook(String title) {
		librarian.addEBook(title);
	}

	private static void addAudioBook(String title) {
		librarian.addAudioBook(title);
	}

	// code changes^
	private static void borrowBook(String title, String name) {
		librarian.borrowBookByMember(title, name);
	}

	private static void returnBook(String title, String name) {
		librarian.returnBookByMember(title, name);
	}

	private static void showMemberBooks(String name) {
		librarian.showMemberBooks(name);
	}

	public static void main(String[] args) {

		System.out.println(" *** Library management system demo *** ");

		// Adding one book, see the Sequence diagram in the lab document.
		addPaperBook("Dune");

		// DONE: Create three sequence diagrams for each of these method calls
		addMember("Alice"); // 1. Add a member
		borrowBook("Dune", "Alice"); // 2. Borrow a book
		returnBook("Dune", "Alice"); // 3. Return book

		// Adding some books to the catalog
		System.out.println("\n *** Adding books to the library:");
		addPaperBook("Dune");
		addEBook("1984");
		addAudioBook("Moby Dick");

		// Adding members to the library
		System.out.println("\n *** Adding members to the library:");
		addMember("Alice");
		addMember("Bob");

		borrowBook("Dune", "Alice");
		borrowBook("1984", "Alice");
		borrowBook("Moby Dick", "Bob");
		borrowBook("Dune", "Bob"); // will be rejected

		System.out.println("\n *** Books borrowed by Alice:");
		showMemberBooks("Alice");
		System.out.println("\n *** Books borrowed by Bob:");
		showMemberBooks("Bob");

		System.out.println("\n *** Book returned by Alice: Dune");
		returnBook("Dune", "Alice");
		borrowBook("Dune", "Bob"); // will be successful
		System.out.println("\n *** Books borrowed by Bob:");
		showMemberBooks("Bob");
	}

}
