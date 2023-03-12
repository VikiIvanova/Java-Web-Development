package bg.uni.fmi.lab02.additional;

import java.time.LocalDate;
import java.util.Map;
import java.util.List;
import java.util.function.Predicate;

public interface Store {
    boolean add(Book o);

    void remove(Book o);

    List<Book> getAllBooksByAuthor(String author);

    List<Book> getAllBooksPublishedAfter(LocalDate from);

    List<Book> getAllBooksBetween(LocalDate from, LocalDate to);

    void clear();

    Map<String, List<Book>> getAllBooksGroupByAuthor();

    Map<String, List<Book>> getAllBooksGroupByPublisher();

    List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate);

}
