package org.javacodegeeks.springintegration.kafka;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.javacodegeeks.springintegration.kafka.incoming.BookPublisher;
import org.javacodegeeks.springintegration.kafka.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
public class Library {

	@Autowired
	private BookPublisher bookPublisher;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(Library.class).web(false).run(args);
		context.getBean(Library.class).run(context);
		context.close();
	}

	private void run(ConfigurableApplicationContext context) {

		System.out.println("Inside ProducerApplication run method...");

		MessageChannel producerChannel = context.getBean("producerChannel", MessageChannel.class);

		List<Book> books = bookPublisher.getBooks();

		for (Book book : books) {
			Map<String, Object> headers = Collections.singletonMap(KafkaHeaders.TOPIC, book.getGenre().toString());
			producerChannel.send(new GenericMessage<>(book.toString(), headers));
		}

		System.out.println("Finished ProducerApplication run method...");
	};
}
