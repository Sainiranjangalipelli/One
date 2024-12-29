package Bookstore.one.start;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Bookstore.one.Book.Book;
import Bookstore.one.Book.Borrow;
import Bookstore.one.Book.User;
import Bookstore.one.springdatajpa.BorrowRepository;

@Service
public class BorrowService {
	
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	@Autowired
	BorrowRepository borrowRepository;
	
//	need to implement borrowing and returning
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Borrow borrowBook(int bookid, int userid)
	{
		Book book = bookService.getBookById(bookid);
		User user = userService.getUserById(userid);
		if(book.canBorrow())
		{
			book.borrow();
			Borrow borrow = new Borrow(book, user);
			borrowRepository.save(borrow);
			return borrow;
		}
		return null;
	}
	
	public Borrow findIfAlreadyBorrowed(int bookid,int userid)
	{
		return borrowRepository.findIfAlreadyBorrowed(bookid,userid).stream().findAny().orElseThrow(null);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void returnBook(int bookid, int userid) {
		Borrow borrow = findIfAlreadyBorrowed(bookid,userid);
		borrow.doReturn();
		borrowRepository.save(borrow);
		
	}
	
	
	
}
