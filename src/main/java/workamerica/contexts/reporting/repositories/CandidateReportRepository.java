package workamerica.contexts.reporting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workamerica.contexts.reporting.entities.CandidateReport;

/**
 * Created by Faizan on 8/11/2016.
 */
@RepositoryRestResource
public interface CandidateReportRepository extends JpaRepository <CandidateReport, Long> {
    CandidateReport findByCandidateID(Long candidateID);
}
