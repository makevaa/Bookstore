package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
	private BookRepository bookRepository;

    @Autowired
	private CategoryRepository categoryRepository;
    




    
    // Show index page
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    
    // Show login page
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String showLogin() {
        return "login";
    }
    

    // Show all books
    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String showBookList(Model model) {
        model.addAttribute( "books", bookRepository.findAll() ); 
        return "booklist";
    }

    // Delete 1 book
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    // Show "Add book" page
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String showAddBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    // Save new book (or update if Book has id)
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    // Show "Edit book" page
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String showEditPage(@PathVariable("id") Long bookId, Model model) {
        Book bookToEdit = bookRepository.findById(bookId).get();
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("book", bookToEdit);
        return "editbook";
    }


}
