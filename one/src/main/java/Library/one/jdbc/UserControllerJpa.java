package Library.one.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Library.one.Book.User;
import Library.one.start.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController 
@RequestMapping("/api/users")
public class UserControllerJpa {
	
	@Autowired
	private UserService userService;
	
	public UserControllerJpa(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping(value="/allusers",method = RequestMethod.GET)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public User getUserById(@PathVariable int id)
	{
		return userService.getUserById(id);
	}
	
	 @ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/add-user",method = RequestMethod.POST)
	public void addUser(@ModelAttribute User user) {
		userService.addUser(user);
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
