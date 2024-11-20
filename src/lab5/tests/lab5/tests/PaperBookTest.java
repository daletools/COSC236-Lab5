package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.PaperBook;

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
