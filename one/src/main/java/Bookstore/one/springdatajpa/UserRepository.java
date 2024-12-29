package Bookstore.one.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Bookstore.one.Book.Book;
import Bookstore.one.Book.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
