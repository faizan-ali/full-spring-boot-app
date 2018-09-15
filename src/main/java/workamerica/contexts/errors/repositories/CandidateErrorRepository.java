package workamerica.contexts.errors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workamerica.contexts.errors.entites.CandidateError;

/**
 * Created by Faizan on 8/16/2016.
 */
@RepositoryRestResource
public interface CandidateErrorRepository extends JpaRepository<CandidateError, Long> {
}
