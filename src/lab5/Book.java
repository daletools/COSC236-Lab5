package lab5;

public interface Book {
	public String toString();
	public void setIsAvailable(boolean available);
	public boolean getIsAvailable();
	public String getTitle();
}


//    1. Why did you introduce the Book interface, and how does this relate to the Dependency Inversion Principle?
//          The introduction of the Book interface reduces the coupling between Member and PaperBook.  This
//          adheres to the DIP by having modules depend on abstractions, rather than each other.

//    2. How does this design improve the flexibility of the system?
//

//    3. Can you explain how your changes support the Open/Closed Principle?
//          The refactoring to use a common interface allows PaperBook to remain closed to modification,
//          while the Book interface is open for extension.

//    4. What did you learn about the benefits of using abstractions and interfaces in this example?
//          
