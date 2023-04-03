package bg.fmi.course.books.service;

import bg.fmi.course.books.model.Book;
import bg.fmi.course.books.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean add(Book book) {
        Book bookByIsbn = bookRepository.getByIsbn(book.getIsbn());
        if (bookByIsbn != null) {
            return false;
        }
        bookRepository.add(book);
        return true;
    }

    @Override
    public void remove(Book book) {

        this.bookRepository.delete(book);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return bookRepository.getByAuthor(author);
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return bookRepository.getAllBooksPublishedAfter(from);
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return bookRepository.getAllBooksBetween(from, to);
    }

    @Override
    public void clear() {
        bookRepository.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return bookRepository.getAllBooksGroupByAuthor();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return bookRepository.getAllBooksGroupByPublisher();
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return bookRepository.getAllBooksFilterBy(bookPredicate);
    }
}