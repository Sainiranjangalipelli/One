package Bookstore.one.springdatajpa;

import java.util.List;

import org.hibernate.annotations.QueryCacheLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Bookstore.one.Book.Book;
import Bookstore.one.Book.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
	@Query("select b from Borrow b where b.book.id = :bookid and b.user.id=:userid and b.isReturned = false")
	List<Borrow> findIfAlreadyBorrowed(@Param("bookid") int bookid, @Param("userid") int userid );
}
