package ma.ensaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import ma.ensaf.model.Book;
import ma.ensaf.model.MyBookList;
import ma.ensaf.service.BookService;
import ma.ensaf.service.MyBookListService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBookListService myBookService;

	@GetMapping("/book_regiter")
	public String bookRegister() {
		return "user/bookRegister";
	}
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> books = bookService.getAllBook();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/bookList");
		mv.addObject("books", books);
		return mv;
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:available_books";
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list= myBookService.getAllMyBooks();
		model.addAttribute("books",list);
		return "user/myBooks";
	}
	
	@GetMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=bookService.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=bookService.getBookById(id);
		model.addAttribute("book",b);
		return "user/bookEdit";
	}
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		bookService.deleteById(id);
		return "redirect:/available_books";
	}

}
