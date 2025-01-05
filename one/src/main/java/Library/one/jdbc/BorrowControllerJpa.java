package Library.one.jdbc;

import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.SessionAttribute;

import Library.one.Book.Book;
import Library.one.start.BorrowService;
import ch.qos.logback.core.model.Model;

@Controller
public class BorrowControllerJpa {
	
	@Autowired
	private BorrowService borrowService;
	
	public BorrowControllerJpa(BorrowService borrowService) {
		this.borrowService = borrowService;
	}
	
	@RequestMapping(value="/getbooks",method = RequestMethod.GET)
//	public String getBorrowedBooks(@PathVariable int userid,ModelMap model)
	public String getBorrowedBooks(@SessionAttribute("userId") int userid,ModelMap model)
	{
		List<Book> books = borrowService.getBorrowedBooks(userid);
//		model.put("id", userid);
		model.put("books", books);
		return "getBorrowed";
		
	}
	
	
	@RequestMapping(value="/book/{bookid}",method = RequestMethod.GET)
	public String borrowBook(@PathVariable int bookid,@SessionAttribute("userId") int userid,ModelMap model)
	{
		System.out.println(userid);
		borrowService.borrowBook(bookid, userid);
//		List<Book> books = borrowService.getBorrowedBooks(userid);
//		model.put("books", books);
//		return "getBorrowed";
		return "redirect:/getbooks";
	}
	
	@RequestMapping(value="/user/book/{bookid}",method = RequestMethod.GET)
	public String returnBook(@PathVariable int bookid,@SessionAttribute("userId") int userid,ModelMap model)
	{
		borrowService.returnBook(bookid, userid);
		return "redirect:/getbooks";
	}
	
}
