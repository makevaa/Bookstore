package hh.sof3.bookstore.web;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BookController {
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

}
