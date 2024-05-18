package ma.ensaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensaf.model.Book;
import ma.ensaf.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public void save(Book book) {
		bookRepository.save(book);
	}
	
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}
	
	// Rest
	public Book findById(int id) {
		return bookRepository.findById(id).orElse(null);
	}
}
