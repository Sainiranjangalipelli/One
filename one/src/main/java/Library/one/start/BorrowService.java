package Library.one.start;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Library.one.Book.Book;
import Library.one.Book.Borrow;
import Library.one.Book.User;
import Library.one.springdatajpa.BookRepository;
import Library.one.springdatajpa.BorrowRepository;

@Service
public class BorrowService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	@Autowired
	BorrowRepository borrowRepository;
	
	public List<Book> getBorrowedBooks(int userid)
	{
		User user = userService.getUserById(userid);
		
		if (user == null) {
	        throw new IllegalArgumentException("User not found with ID: " + userid);
	    }
		
		List<Integer> bookIds = borrowRepository.findByUserId(userid);

		List<Book> books = bookRepository.findAllById(bookIds);

	    return books;
	}
	
//	need to implement borrowing and returning
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void borrowBook(int bookid, int userid)
	{
		Book book = bookService.getBookById(bookid);
		User user = userService.getUserById(userid);
		if(book.canBorrow())
		{
			book.borrow();
			Borrow borrow = new Borrow(book, user);
			borrowRepository.save(borrow);
//			return borrow;
		}
//		return null;
	}
	
	public Borrow findIfAlreadyBorrowed(int bookId,int userId)
	{
		return borrowRepository.findIfAlreadyBorrowed(bookId,userId).stream().findAny().orElseThrow(null);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void returnBook(int bookid, int userid) {
		Borrow borrow = findIfAlreadyBorrowed(bookid,userid);
		borrow.doReturn();
		borrowRepository.save(borrow);
		
	}
	
	
	
}
