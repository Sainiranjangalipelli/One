package Library.one.jdbc;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.SessionAttribute;

import Library.one.Book.Book;
import Library.one.springdatajpa.BookRepository;
import Library.one.start.BookService;

@Controller
public class BookControllerJpa {
	
	@Autowired
	private BookService bookservice;
	
	public BookControllerJpa(BookService service) {
		super();
		this.bookservice = service;
	}
	
	@RequestMapping("/")
	public String list() {
		return "welcome";
	}

	@RequestMapping(value="add-book", method = RequestMethod.POST)
	public void addBook(@RequestBody Book book) {
		
		bookservice.addBook(book);
		
	}
	
	@RequestMapping(value="get-book/{name}",method = RequestMethod.GET)
	public Book getBookByname(@PathVariable("name") String name) {
		Book book = bookservice.getBookByname(name);
		return book;
	}
	
	@RequestMapping(value="get-author-books",method = RequestMethod.GET)
	public List<Book> getBooksByAuthorName(String name){
		List<Book> books = bookservice.getBooksByAuthorName(name);
		return books;
	}
	
	@RequestMapping(value="delete-book/{name}",method = RequestMethod.DELETE)
	public void deleteBookByName(@PathVariable("name") String name)
	{
		bookservice.deleteBookByName(name);
		
	}
	
	@RequestMapping(value="/all-books",method = RequestMethod.GET)
	public String allBooks(ModelMap model,@SessionAttribute(value = "userId") int userId){
		System.out.println(userId);
		System.out.println(userId);
		System.out.println(userId);
		System.out.println(userId);
		List<Book> books = bookservice.allBooks();
		model.addAttribute("books", books);
		return "UserBooks";
	}
	
	@RequestMapping(value="update-book",method = RequestMethod.POST)
	public void updateBook(@RequestBody Book book) {
		
		bookservice.updateBook(book);
		
	}
	
	
	
	
}
