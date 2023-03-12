package bg.uni.fmi.lab02.additional;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store {

    private Set<Book> books;

    public BookStore() {
        books = new HashSet<>();
    }

    @Override
    public boolean add(Book book) {
        return books.add(book);
    }

    @Override
    public void remove(Book book) {
        books.remove(book);
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return books.stream()
                .filter(book -> book.getPublishedYear().isAfter(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return books.stream()
                .filter(book -> book.getPublishedYear().isAfter(from) && book.getPublishedYear().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        books.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return books.stream()
                .filter(bookPredicate)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        BookStore store = new BookStore();
//        Book book1 = new Book("Title1", "Author1", new BigDecimal(10.99), "Publisher1", LocalDate.of(2020, 1, 1));
//        Book book2 = new Book("Title2", "Author2", new BigDecimal(12.99), "Publisher2", LocalDate.of(2019, 1, 1));
//        Book book3 = new Book("Title3", "Author3", new BigDecimal(9.99), "Publisher3", LocalDate.of(2021, 1, 1));
//        store.add(book1);
//        store.add(book2);
//        store.add(book3);
//
//
//        System.out.println(store.getAllBooksByAuthor("Author1"));
//        System.out.println(store.getAllBooksPublishedAfter(LocalDate.of(2020, 1, 1)));
//        System.out.println(store.getAllBooksBetween(LocalDate.of(2019, 1, 1), LocalDate.of(2020, 1, 1)));
//        System.out.println(store.getAllBooksFilterBy(book -> book.getPrice().compareTo(new BigDecimal(10)) > 0));
//        System.out.println(store.getAllBooksGroupByAuthor());
//        store.remove(book1);
//        System.out.println(store.getAllBooksGroupByPublisher());
//        store.clear();
//        System.out.println(store.getAllBooksFilterBy(book -> true));
    }
}
