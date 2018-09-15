package workamerica.contexts.reporting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import workamerica.contexts.companies.entities.Company;
import workamerica.contexts.companies.entities.CompanyAccount;
import workamerica.contexts.reporting.entities.CompanyAccountReport;

/**
 * Created by Faizan on 8/16/2016.
 */
@RepositoryRestResource
public interface CompanyAccountReportRepository extends JpaRepository<CompanyAccountReport, Long> {
    CompanyAccountReport findByCompanyAccountID(Long companyAccountID);
}
