package ma.ensaf.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import ma.ensaf.model.Book;
import ma.ensaf.model.MyBookList;
import ma.ensaf.service.BookService;
import ma.ensaf.service.MyBookListService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookRestController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService myBookService;

	
	@GetMapping("/books")
	public List<Book> getAllBook() {
		return bookService.getAllBook();
	}
	
	@PostMapping("/books")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:available_books";
	}
	
	@GetMapping("/mybooks")
	public List<MyBookList> getMyBooks(Model model)
	{
		return myBookService.getAllMyBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getMyList(@PathVariable("id") int id) {
		return bookService.findById(id);
	}
	
	@PutMapping("/books/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=bookService.getBookById(id);
		model.addAttribute("book",b);
		return "user/bookEdit";
	}
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		bookService.deleteById(id);
		return "redirect:/available_books";
	}

}
