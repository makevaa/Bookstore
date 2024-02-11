package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
	private BookRepository bookRepository;
    
    // Show index page
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    // Show all books
    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String showBookList(Model model) {
        model.addAttribute( "books", bookRepository.findAll() ); 
        return "booklist";
    }

    // Delete 1 book
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    // Show "Add book" page
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String showAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    // Save new book
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    // Show "Edit book" page
    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public String showEditPage(@PathVariable("id") Long bookId, Model model) {
        Book bookToEdit = bookRepository.findById(bookId).get();
        model.addAttribute("book", bookToEdit);
        return "editbook";
    }

    // Update book (with new form data)
    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

}
