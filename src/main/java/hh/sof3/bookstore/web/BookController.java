package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
	private BookRepository bookRepository;
    
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

}
