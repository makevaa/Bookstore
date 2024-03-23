package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository repository;

    @Autowired
    TestEntityManager entityManager;

    // Test finding book by title
    @Test 
    public void findBookByTitle() {
        Book book = new Book("Dune", null, null, null, 0, null);
        repository.save(book);
        List<Book> books = repository.findByTitle("Dune");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Dune");
    }

    // Test creating a new book
    @Test
    public void createBook() {
        Book book = new Book(null, null, null, null, 0, null);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    // Test deleting a book
    @Test
    public void deleteBook() {
        Book book = new Book(null, null, null, null, 0, null);
        entityManager.persist(book);
        repository.delete(book);
	    assertThat(entityManager.find(Book.class, book.getId())).isNull();
    }
}