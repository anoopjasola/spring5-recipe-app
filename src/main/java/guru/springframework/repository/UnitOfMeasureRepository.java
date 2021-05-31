package guru.springframework.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.UnitOfMeassure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeassure, Long> {
	Optional<UnitOfMeassure> findByDescription(String description);

}
