package workamerica.contexts.companies.repositories;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import workamerica.contexts.companies.entities.Company;

import java.util.List;

/**
 * Created by Faizan on 8/5/2016.
 */
@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Cacheable("companies")
    List<Company> findByCategoriesIgnoreCaseContaining(String categories);

    Company findNameByCompanyID(Long companyID);

    Company findByName(String name);
}
