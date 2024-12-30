package Library.one.jdbc;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Library.one.start.BorrowService;

@RestController
@RequestMapping("/api/Borrow")
public class BorrowControllerJpa {
	
	@Autowired
	private BorrowService borrowService;
	
	public BorrowControllerJpa(BorrowService borrowService) {
		this.borrowService = borrowService;
	}
	
	@RequestMapping(value="/user/{userid}/book/{bookid}",method = RequestMethod.POST)
	public void borrowBook(@PathVariable int userid, @PathVariable int bookid)
	{
		borrowService.borrowBook(bookid, userid);
	}
	
	@RequestMapping(value="/user/{userid}/book/{bookid}",method = RequestMethod.PUT)
	public void returnBook(@PathVariable int userid,@PathVariable int bookid)
	{
		borrowService.returnBook(bookid, userid);
	}
	
}
