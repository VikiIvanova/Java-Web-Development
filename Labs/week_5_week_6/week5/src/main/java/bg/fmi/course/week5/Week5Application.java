package bg.fmi.course.week5;

import bg.fmi.course.week5.model.Book;
import bg.fmi.course.week5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week5Application implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {

		SpringApplication.run(Week5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(">>>>");
		bookService.clear();
	}
}
