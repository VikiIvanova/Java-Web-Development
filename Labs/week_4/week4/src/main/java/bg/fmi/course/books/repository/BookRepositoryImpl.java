package bg.fmi.course.books.repository;

import bg.fmi.course.books.model.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BookRepositoryImpl implements BookRepository{
    private Map<String, Book> db;

    public BookRepositoryImpl(){
        this.db = new HashMap<>();
    }

    @Override
    public boolean add(Book book) {
        db.put(book.getIsbn(), book);
        return false;
    }

    @Override
    public void delete(Book book) {
        db.remove(book.getIsbn(), book);
    }

    @Override
    public Book getByIsbn(String isbn) {
        return (Book) db.values()
                .stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getByAuthor(String author) {
        return db.values()
                .stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return db.values()
                .stream()
                .filter(book -> book.getPublishedYear().isAfter(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return db.values()
                .stream()
                .filter(book -> book.getPublishedYear().isAfter(from) && book.getPublishedYear().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        db.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return db.values()
                .stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return db.values()
                .stream()
                .collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return db.values()
                .stream()
                .filter(bookPredicate)
                .collect(Collectors.toList());
    }


}