package hh.sof3.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import hh.sof3.bookstore.domain.Book;
import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
	private CategoryRepository categoryRepository;
    

    // Show all categories
    @RequestMapping(value="/categorylist", method=RequestMethod.GET)
    public String showCategoryList(Model model) {
        model.addAttribute( "categories", categoryRepository.findAll() ); 
        return "categorylist";
    }

    // Show "Add category" page
    @RequestMapping(value="/addcategory", method=RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    // Save new category (or update if Category has id)
    @RequestMapping(value="/savecategory", method=RequestMethod.POST)
    public String save(Category category) {
        categoryRepository.save(category);
        return "redirect:categorylist";
    }
}
