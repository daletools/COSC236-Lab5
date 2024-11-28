package lab5;

public class EBookFactory extends BookFactory {
	Book createBook(String s) {
		return new EBook(s);
	}
}
