package lab5;

public interface BorrowingServiceAPI {
	public BorrowingBookResult borrowBook(Member member, Book book);

	public BorrowingBookResult returnBook(Member member, Book book);
}
