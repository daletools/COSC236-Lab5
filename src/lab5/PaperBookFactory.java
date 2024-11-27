package lab5;

public class PaperBookFactory extends BookFactory{
	Book createBook(String s) {
		return new PaperBook(s);
	}
}
