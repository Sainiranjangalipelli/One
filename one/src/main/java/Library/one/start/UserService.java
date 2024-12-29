package Library.one.start;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import Library.one.Book.User;
import Library.one.springdatajpa.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository)
	{
		super();
		this.userRepository=userRepository;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
//		Optional<User> userOptional = userRepository.findById(id);
//		if(userOptional.isPresent())
//		{
//			return userOptional.get();
//		}
//		return userRepository.getById(id);
		return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public User addUser(User user) {
        return userRepository.save(user);
    }
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User updateUser(int id, User newuser) {
		User user = getUserById(id);
		user.setName(Objects.toString(newuser.getName(),user.getName()));
		user.setAddress(Objects.toString(newuser.getAddress(),user.getAddress()));
		user.setEmailAddress(Objects.toString(newuser.getPhoneNumber(),user.getPhoneNumber()));
		user.setPhoneNumber(Objects.toString(newuser.getPhoneNumber(),user.getPhoneNumber()));
		return userRepository.save(user);	
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	

}
