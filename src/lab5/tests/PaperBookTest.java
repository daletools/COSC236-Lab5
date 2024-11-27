package lab5.tests;

import lab5.Book;
import lab5.PaperBook;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaperBookTest {

  @BeforeEach
  void setUp() throws Exception {
  }

  @Test
  void testClassType() {
    Book book = new PaperBook("Harry Potter");

    assertEquals("lab5.PaperBook", book.getClass().getName());
    assert(book instanceof lab5.Book);
  }
}
