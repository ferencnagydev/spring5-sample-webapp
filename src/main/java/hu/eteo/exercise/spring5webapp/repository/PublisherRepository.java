package hu.eteo.exercise.spring5webapp.repository;

import hu.eteo.exercise.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
