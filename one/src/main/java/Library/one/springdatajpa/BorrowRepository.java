package Library.one.springdatajpa;

import java.util.List;

import org.hibernate.annotations.QueryCacheLayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Library.one.Book.Book;
import Library.one.Book.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
	
	@Query("select b from Borrow b where b.book.id = :bookId and b.user.id=:userId and b.isReturned = false")
	List<Borrow> findIfAlreadyBorrowed(@Param("bookId") int bookid, @Param("userId") int userid );
	
//	@Query("select b.book.id from Borrow b where b.user.id=:userId")
//	List<Integer> findByUserId(int userId);
	@Query("SELECT b.book.id, b.isReturned FROM Borrow b WHERE b.user.id = :userId")
	List<Object[]> findBookIdAndIsReturnedByUserId(@Param("userId") int userId);
}
