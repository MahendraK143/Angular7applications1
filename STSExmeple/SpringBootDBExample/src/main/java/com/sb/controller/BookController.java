package com.sb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sb.model.Book;
import com.sb.repository.BookRepository;

@Controller
@RequestMapping("/")
public class BookController {
	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
	private BookRepository bookRepository;

	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
	public String readersBooks(Model model) {
		List<Book> readingList = bookRepository.findAll();
		if (readingList != null) {
			model.addAttribute("books", readingList);
		}
		model.addAttribute("books", readingList);
		return "index";
	}

	@RequestMapping(value = "/{reader}", method = RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		bookRepository.save(book);
		return "redirect:/{reader}";
	}
}
