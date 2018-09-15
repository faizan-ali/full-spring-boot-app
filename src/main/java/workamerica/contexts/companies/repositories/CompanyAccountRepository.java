package workamerica.contexts.companies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workamerica.contexts.companies.entities.Company;
import workamerica.contexts.companies.entities.CompanyAccount;

/**
 * Created by Faizan on 8/16/2016.
 */
@RepositoryRestResource
public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Long> {
    CompanyAccount findByEmail(String email);
}
