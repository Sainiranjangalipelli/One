package Library.one.Book;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_books")
public class Book {
	
	@Id
//	@GeneratedValue
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "bookName")
	@Getter
	private String bookName;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "description")
	private String description;
	
//	@Column(name = "isbn", length = 50, nullable = false, unique = true)
//    @NotNull(message = "Book ISBN must not be Null")
//    private String isbn;

    @Column(name = "publication_year")
    @NotNull(message = "Book publication year must not be Null")
    private Timestamp publicationYear;

    private Integer quantity = 0;
    
//    private Integer taken =0;

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", description=" + description
				+ ", publicationYear=" + publicationYear + ", quantity=" + quantity + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public String getIsbn() {
//		return isbn;
//	}
//
//	public void setIsbn(String isbn) {
//		this.isbn = isbn;
//	}

	public Timestamp getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Timestamp publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
//		this.taken = 0;
	}
	
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    List<Borrow> borrows;

    public boolean canBorrow() {
        return quantity > 0;
    }

//    public Integer getTaken() {
//		return taken;
//	}

	public void borrow() {
        if (canBorrow()) {
//        	taken++;
            quantity--;
            
        }
    }

    public void returnBook() {
//    	taken--;
        quantity++;
        
    }
	
	
//	@Column(name = "lended")
//	private boolean lended;
//	
//	@Column(name = "returned")
//	private boolean returned;
	
	
	
	
	
}
