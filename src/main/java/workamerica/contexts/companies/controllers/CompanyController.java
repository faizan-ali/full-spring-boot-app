package workamerica.contexts.companies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import workamerica.contexts.companies.components.CompanyComponent;
import workamerica.contexts.companies.entities.Company;

import javax.servlet.annotation.MultipartConfig;

/**
 * Created by Faizan on 8/8/2016.
 */
@RestController
@RequestMapping("/companies")
@MultipartConfig(fileSizeThreshold = 120971520)
public class CompanyController {

    @Autowired
    CompanyComponent component;

    @RequestMapping(method = RequestMethod.POST)
    public Company create (@RequestBody Company company) {
        if (company != null) {
            return component.create(company);
        }
        return new Company();
    }

    @RequestMapping(value = "/{companyID}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public Company addPicture (@PathVariable Long companyID, @RequestParam("image") MultipartFile image) {
        if (companyID != null && companyID > 0) {
            return component.addPicture(image, companyID, image.getOriginalFilename());
        }
        return null;
    }
}
