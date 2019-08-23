package org.javacodegeeks.springintegration.kafka.incoming;

import java.util.ArrayList;
import java.util.List;

import org.javacodegeeks.springintegration.kafka.model.Book;
import org.javacodegeeks.springintegration.kafka.model.Book.Genre;
import org.springframework.stereotype.Component;

@Component
public class BookPublisher {
	private long nextBookId;

	public BookPublisher() {
		this.nextBookId = 1001l;
	}

	public List<Book> getBooks() {
		List<Book> books = new ArrayList<Book>();

		books.add(createFantasyBook());
		books.add(createFantasyBook());
		books.add(createFantasyBook());
		books.add(createFantasyBook());
		books.add(createFantasyBook());
		books.add(createHorrorBook());
		books.add(createHorrorBook());
		books.add(createHorrorBook());
		books.add(createHorrorBook());
		books.add(createHorrorBook());
		books.add(createRomanceBook());
		books.add(createRomanceBook());
		books.add(createRomanceBook());
		books.add(createRomanceBook());
		books.add(createRomanceBook());
		books.add(createThrillerBook());
		books.add(createThrillerBook());
		books.add(createThrillerBook());
		books.add(createThrillerBook());
		books.add(createThrillerBook());

		return books;
	}

	Book createFantasyBook() {
		return createBook("", Genre.fantasy);
	}

	Book createHorrorBook() {
		return createBook("", Genre.horror);
	}

	Book createRomanceBook() {
		return createBook("", Genre.romance);
	}

	Book createThrillerBook() {
		return createBook("", Genre.thriller);
	}

	Book createBook(String title, Genre genre) {
		Book book = new Book();
		book.setBookId(nextBookId++);
		if (title == "") {
			title = "# " + Long.toString(book.getBookId());
		}
		book.setTitle(title);
		book.setGenre(genre);

		return book;
	}
}
