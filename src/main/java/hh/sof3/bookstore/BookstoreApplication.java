package hh.sof3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			bookRepository.save(new Book("Quantum Thief", "Hannu Rajaniemi", 2011, "9789512083954", 19.90));
			bookRepository.save(new Book("Solaris", "Stanislaw Lem", 1993, "951-31-1450-3", 29.90));
			bookRepository.save( new Book("Small Gods", "Terry Pratchett", 1992, "9789512349784", 14.90) );

			categoryRepository.save(new Category("scifi"));
			categoryRepository.save(new Category("fantasy"));

			for (Book book : bookRepository.findAll() ) {
				System.out.println(book.toString());
			}

			for (Category category : categoryRepository.findAll() ) {
				System.out.println(category.toString());
			}
		};
	}



}
