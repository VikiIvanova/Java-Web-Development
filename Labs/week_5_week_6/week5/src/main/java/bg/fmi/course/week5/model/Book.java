package bg.fmi.course.week5.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
public class Book {
   private  String title;
   private String author;
   private BigDecimal price;
   private String publisher;
   private String isbn;
   private LocalDate publishedYear;

   public void setIsbn(String isbn) {
       this.isbn = isbn;
   }

   public void setTitle(String title) {
       this.title = title;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public void setPublisher(String publisher) {
       this.publisher = publisher;
   }

   public void setPublisherYear(LocalDate publishedYear) {
       this.publishedYear = publishedYear;
   }

   public String getTitle() {
       return title;
   }

   public String getAuthor() {
       return author;
   }

   public BigDecimal getPrice() {
       return price;
   }

   public String getPublisher() {
       return publisher;
   }

   public LocalDate getPublisherYear() {
       return publishedYear;
   }

   public String getIsbn() {
       return isbn;
   }

   @Override
    public boolean equals(Object o) {
       if(this == o) {
           return true;
       }
       if(o == null || getClass() != o.getClass()){
           return false;
       }
       Book book = (Book) o;
       return Objects.equals(title, book.title)
               && Objects.equals(author, book.author)
               && Objects.equals(price, book.price)
               && Objects.equals(publisher, book.publisher)
               && Objects.equals(publishedYear, book.publishedYear);
   }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
   }
}
