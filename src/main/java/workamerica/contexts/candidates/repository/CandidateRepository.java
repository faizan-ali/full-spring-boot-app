package workamerica.contexts.candidates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workamerica.contexts.candidates.entities.Candidate;

/**
 * Created by Faizan on 8/2/2016.
 */
@RepositoryRestResource
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findByEmail(String email);
    Candidate findByEmailOrPhoneOrAlternatePhone (String userName, String phone, String alternatePhone);
}
