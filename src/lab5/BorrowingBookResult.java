package lab5;

public class BorrowingBookResult {
	private boolean isSuccess;
	private String borrowingMessage;
	public BorrowingBookResult(boolean b, String s){
		isSuccess = b;
		borrowingMessage = s;
	}
	public boolean getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(boolean b) {
		isSuccess = b;
	}
	public String getBorrowingMessage() {
		return borrowingMessage;
	}
	public void setBorrowingMessage(String s) {
		borrowingMessage = s;
	}
}
