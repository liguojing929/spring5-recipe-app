package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    /**
     JPA Query Method:
     Naming convention: findByPropertyName
     Spring will automatically generate a query based on the data type (table), and
     the query parameter for us to look up into the database.
     So in here:
     JPA will create a query as select * from UnitOfMeasure where description = INPUT_PARAMETER.
     */
    Optional<UnitOfMeasure> findByDescription(String description);
}
