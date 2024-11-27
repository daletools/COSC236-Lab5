package lab5;

public class BorrowingService implements BorrowingServiceAPI{
	private static BorrowingService instance;
	private int borrowingLimit;
	private BorrowingService() {
		borrowingLimit = 3;
	}
	public static BorrowingService getInstance() {
		if(instance == null)
			instance = new BorrowingService();
		return instance;
	}
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book) {
		BorrowingBookResult output = new BorrowingBookResult(false, "");

		if(member == null) {
			output.setIsSuccess(false);
			output.setBorrowingMessage("The member does not exist.");
		}else if(member.getBorrowedBooks().contains(book)) {
			output.setIsSuccess(false);
			output.setBorrowingMessage("The member has already borrowed this book.");
		}else if(book == null) {
			output.setIsSuccess(false);
			output.setBorrowingMessage("The book does not exist.");
		}else if(!book.getIsAvailable()){
			output.setIsSuccess(false);
			output.setBorrowingMessage(book + " is not available.");
		} else if (member.borrowedBooksCount() == borrowingLimit) {
			output.setIsSuccess(false);
			output.setBorrowingMessage("The member has reached their borrowed books limit.");
		}else {
			output.setIsSuccess(true);
			output.setBorrowingMessage(member + " borrowed " + book);
			member.getBorrowedBooks().add(book);
			book.setIsAvailable(false);
		}
		return output;
	}
	@Override
	public BorrowingBookResult returnBook(Member member, Book book) {
		BorrowingBookResult output = new BorrowingBookResult(false, "");
		
		if(member == null) {
			output.setIsSuccess(false);
			output.setBorrowingMessage("The member does not exist.");
		}else if(!member.getBorrowedBooks().contains(book)) {
			output.setIsSuccess(false);
			output.setBorrowingMessage("The member hasn't borrowed this book and can't return it.");
		}else if(book == null) {
			output.setIsSuccess(false);
			output.setBorrowingMessage("The book does not exist.");
		}else {
			output.setIsSuccess(true);
			output.setBorrowingMessage(member + " returned " + book);
			member.getBorrowedBooks().remove(book);
			book.setIsAvailable(true);
		}
		return output;
	}
}
