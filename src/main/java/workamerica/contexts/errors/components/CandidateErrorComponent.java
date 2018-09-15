package workamerica.contexts.errors.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import workamerica.contexts.errors.entites.CandidateError;
import workamerica.contexts.errors.repositories.CandidateErrorRepository;

/**
 * Created by Faizan on 8/16/2016.
 */
@Component
public class CandidateErrorComponent {

    @Autowired
    CandidateErrorRepository repository;

    public void create(Long candidateID, String feature, String exception) {
        if (candidateID != null && candidateID > 0) {
            CandidateError error = new CandidateError(candidateID, feature, exception);
            repository.save(error);
        }
    }
}
