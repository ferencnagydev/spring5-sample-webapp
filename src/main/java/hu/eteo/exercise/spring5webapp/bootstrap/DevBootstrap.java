package hu.eteo.exercise.spring5webapp.bootstrap;

import hu.eteo.exercise.spring5webapp.model.Author;
import hu.eteo.exercise.spring5webapp.model.Book;
import hu.eteo.exercise.spring5webapp.model.Publisher;
import hu.eteo.exercise.spring5webapp.repository.AuthorRepository;
import hu.eteo.exercise.spring5webapp.repository.BookRepository;
import hu.eteo.exercise.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author rick = new Author("Richard", "Castle");
        Publisher spookyPublisher = new Publisher("Spooky Roads", "Spooky Street 12th");
        Book heatWave = new Book("Heat Wave", "1234-5678", spookyPublisher);
        rick.getBooks().add(heatWave);
        heatWave.getAuthors().add(rick);

        authorRepository.save(rick);
        publisherRepository.save(spookyPublisher);
        bookRepository.save(heatWave);

        Author steve = new Author("Stephen", "King");
        Publisher mainePublisher = new Publisher("Maine Publications", "Maine Street 666th");
        Book it = new Book("It", "4356-7457", mainePublisher);
        steve.getBooks().add(it);

        authorRepository.save(steve);
        publisherRepository.save(mainePublisher);
        bookRepository.save(it);
    }
}
