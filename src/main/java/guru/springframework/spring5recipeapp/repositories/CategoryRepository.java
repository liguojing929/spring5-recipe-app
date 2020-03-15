package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    /**
     * Optional<T>:
     * A container object which may or may not contain a non-null value. If a value is present,
     * isPresent() will return true and get() will return the value.
     */
    Optional<Category> findByDescription(String description);
}
