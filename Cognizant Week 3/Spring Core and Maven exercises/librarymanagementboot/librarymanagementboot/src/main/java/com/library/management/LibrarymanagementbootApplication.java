package com.library.management;

import com.library.management.entity.Book;
import com.library.management.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibrarymanagementbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarymanagementbootApplication.class, args);
	}

	// This runs automatically when the app starts
	@Bean
	public CommandLineRunner demo(BookRepository repo) {
		return args -> {
			repo.save(new Book("Spring in Action"));
			repo.save(new Book("Clean Code"));
			repo.save(new Book("Effective Java"));
		};
	}
}
