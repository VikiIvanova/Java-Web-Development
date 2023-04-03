package bg.fmi.course.books.repository;

import bg.fmi.course.books.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public interface BookRepository {

    boolean add(Book book);

    void delete(Book book);

    Book getByIsbn(String isbn);

    List<Book> getByAuthor(String author);

    List<Book> getAllBooksPublishedAfter(LocalDate from);

    List<Book> getAllBooksBetween(LocalDate from, LocalDate to);

    void clear();

    Map<String, List<Book>> getAllBooksGroupByAuthor();

    public Map<String, List<Book>> getAllBooksGroupByPublisher();

    List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate);

}