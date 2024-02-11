package hh.sof3.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {

			Book book1 = new Book("Kvanttivaras", "Hannu Rajaniemi", 2011, "9789512083954", 19.90);

			Book book2 = new Book("Solaris", "Stanislaw Lem", 1993, "951-31-1450-3", 29.90);

			bookRepository.save(book1);
			bookRepository.save(book2);
		};
	}



}
