package hh.sof3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;
import hh.sof3.bookstore.domain.UserRepository;
import hh.sof3.bookstore.domain.User;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {

			Category cat1 = new Category("scifi");
			Category cat2 = new Category("fantasy");
			Category cat3 = new Category("horror");

			categoryRepository.save(cat1);
			categoryRepository.save(cat2);
			categoryRepository.save(cat3);

			Book book1 = new Book("Quantum Thief", "Hannu Rajaniemi", 2011, "9789512083954", 19.90, cat1);
			Book book2 = new Book("Solaris", "Stanislaw Lem", 1993, "951-31-1450-3", 29.90, cat1);
			Book book3 = new Book("Small Gods", "Terry Pratchett", 1992, "9789512349784", 14.90, cat2);

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);


			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$hvSsp.0rKbIDyDawzQS0Ae6xmgWAQQp44rGdHiiI76SvQCzhHMzTO", "USER");
			User user2 = new User("admin","$2a$10$C1.SktkimBQccPPj0QOnm.XN63vX156Qjrmeo.af8.LAem3d.88Va", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);


			for (Book book : bookRepository.findAll() ) {
				log.info(book.toString());
			}

			for (Category category : categoryRepository.findAll() ) {
				log.info(category.toString());
			}

			for (User user : userRepository.findAll() ) {
				log.info(user.toString());
			}
		};
	}



}
