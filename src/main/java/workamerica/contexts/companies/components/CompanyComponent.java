package workamerica.contexts.companies.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import workamerica.contexts.companies.entities.Company;
import workamerica.contexts.companies.repositories.CompanyRepository;
import workamerica.contexts.external.aws.S3Object;
import workamerica.contexts.utilities.FileUtilities;
import workamerica.contexts.utilities.StringUtilities;

import java.util.List;

/**
 * Created by Faizan on 8/8/2016.
 */
@Component
public class CompanyComponent {

    @Autowired
    CompanyRepository repository;

    @Autowired
    CompanyComponent(CompanyRepository repository) {
        this.repository = repository;
    }

    public Long createFromWebsite(String name, String categories) {
        if (name != null && !name.isEmpty()) {
            Company company = findByName(name);

            if (company != null) {
                return company.getCompanyID();
            } else {
                company = new Company(name, categories);
            }

            company = repository.save(company);
            if (company != null) {
                return company.getCompanyID();
            }
        }
        return null;
    }

    public List<Company> getByCategory(String category) {
        if (category != null && !category.isEmpty()) {
            return repository.findByCategoriesIgnoreCaseContaining(category);
        }
        return null;
    }

    public Company findByName(String name) {
        if (name != null && !name.isEmpty()) {
            return repository.findByName(name);
        }
        return null;
    }

    public String [] getNameAndImageByID(Long companyID) {
        if (companyID != null && companyID > 0) {
            Company company = repository.findNameByCompanyID(companyID);
            if (company != null) {
                String name = company.getName();
                String image = company.getPicture();
                name = name == null ? "" : name;
                image = image == null ? "" : image;
                return new String [] {name, image};
            }
        }
        return new String [] {"", ""};
    }

    public Company addPicture(MultipartFile file, Long companyID, String name) {
        if (file != null && companyID != null && companyID > 0 && name != null && name.contains(".")) {
            try {
                Company company = repository.findOne(companyID);

                if (company != null) {
                    String[] split = name.split("\\.");
                    String extension = "." + split[split.length - 1];
                    String fileName = companyID + "/profile" + extension;
                    boolean success = S3Object.uploadCompanyImage(FileUtilities.inputStreamToFile(file.getInputStream()), fileName);

                    if (success) {
                        company.setPicture("https://s3-us-west-2.amazonaws.com/workamerica-public/images/companies/" + fileName);
                        company = repository.save(company);
                        return company;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Company create(Company company) {
        if (company != null) {
            company = validate(company);
            return repository.save(company);
        }
        return null;
    }

    public Company validate(Company company) {
        if (company != null) {
            String name = company.getName();
            String categories = company.getCategories();
            name = name == null ? "" : StringUtilities.capitalizeFirstLetter(name);
            company.setName(name);
            company.setCategories(categories);
            return company;
        }
        return null;
    }
}
