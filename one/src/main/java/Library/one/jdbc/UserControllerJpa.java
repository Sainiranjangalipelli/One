package Library.one.jdbc;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import Library.one.Book.Book;
import Library.one.Book.User;
import Library.one.start.BorrowService;
import Library.one.start.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@SessionAttributes("userId")
public class UserControllerJpa {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BorrowService borrowService;
	
	public UserControllerJpa(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping(value="/allusers",method = RequestMethod.GET)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/user/{id}",method = RequestMethod.GET)
	public User getUserById(@PathVariable int id)
	{
		return userService.getUserById(id);
	}
	
	 @ResponseStatus(HttpStatus.CREATED)
		@RequestMapping(value="/add-user",method = RequestMethod.POST)
		public String addUser(@ModelAttribute("user") User user, ModelMap model) {			
			userService.addUser(user);
			Long id = user.getId();
			int id1 = id.intValue(); 
			List<Book> books = borrowService.getBorrowedBooks(id1);
			model.put("userId", id1);
			model.put("books", books);
			return "getBorrowed";
		}
	
//	 @ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/valid-user",method = RequestMethod.GET)
	public String validUser(ModelMap model) {
			User user = new User(null,"name","description","phone","email");
			model.put("user", user);
			return "AddUser";
	}
	 
	@RequestMapping(value="/update/{id}",method = RequestMethod.POST)
	public User updateUser(@PathVariable int id, @RequestBody User user)
	{
		return userService.updateUser(id, user);
	}
	
//	@ResponseStatus(HttpStatus.)
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable int id)
	{
		userService.deleteUser(id);
	}
	

}
