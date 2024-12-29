package Library.one.start;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import Library.one.Book.Book;
import Library.one.springdatajpa.BookRepository;

@Service
@Transactional
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public BookService(BookRepository repository) {
		super();
		this.repository = repository;
	}
	
	public void addBook(Book book)
	{
		repository.save(book);
	}
	
	public Book getBookByname(String name)
	{
		Book book = repository.findByBookName(name);
		return book;
	}
	
	public List<Book> getBooksByAuthorName(String name){
		List<Book> books = repository.findByAuthor(name);
		return books;
	}
	
	public void deleteBookByName(String name)
	{
		Book book = repository.findByBookName(name);
		repository.delete(book);
	}
	
	public List<Book> allBooks(){
		List<Book> books = repository.findAll();
		return books;
	}
	
	public Book getBookById(int id) {
//		return repository.findById(id).orElseThrow(()->IllegalArgumentException());
		Optional<Book> book = repository.findById(id);
		if(book.isPresent())
		{
			return book.get();
		}
		return null;
	}
	
	public void updateBook(Book book) {
		String nameString = book.getBookName();
		Book book1 =  repository.findByBookName(nameString);
		repository.delete(book1);
		repository.save(book);
		
	}
	
	
	
}
