package bg.fmi.course.week5.repository;

import bg.fmi.course.week5.model.Book;

import java.util.List;

public interface BookRepository {

    void add(Book book);

    Book getByIsbn(String isbn);

    List<Book> getBooks();

    List<Book> getAllBooksByAuthor(String author);

    class BookRepositoryImpl {
    }
}
