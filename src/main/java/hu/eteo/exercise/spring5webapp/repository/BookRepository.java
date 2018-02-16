package hu.eteo.exercise.spring5webapp.repository;

import hu.eteo.exercise.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
