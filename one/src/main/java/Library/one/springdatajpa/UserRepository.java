package Library.one.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Library.one.Book.Book;
import Library.one.Book.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
