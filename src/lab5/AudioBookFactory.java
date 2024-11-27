package lab5;

public class AudioBookFactory extends BookFactory{
	Book createBook(String s) {
		return new AudioBook(s);
	}
}
