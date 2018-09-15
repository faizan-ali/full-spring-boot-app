package workamerica.contexts.criteria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workamerica.contexts.criteria.entities.Field;

import java.util.List;

/**
 * Created by Faizan on 8/5/2016.
 */
@RepositoryRestResource
public interface FieldRepository extends JpaRepository<Field, Long> {
    List<Field> findByCategory (String category);
    Field findNameByFieldID(Long fieldID);
}
