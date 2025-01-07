package Library.one.Book;

public class BookWithQuantity {
    private Book book;
    private Integer quantity;

    public BookWithQuantity(Book book, Integer quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public Integer getquantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "BookWithNumber{book=" + book + ", number=" + quantity + "}";
    }
}
