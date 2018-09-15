package workamerica.contexts.gateways.website.conversion.models.candidates;

import workamerica.contexts.companies.entities.Company;
import workamerica.contexts.criteria.entities.Field;

import java.util.List;

/**
 * Created by Faizan on 8/5/2016.
 */
public class CandidateConversionResponse {

    private List<Field> fields;
    private List<Company> companies;

    public CandidateConversionResponse() {}

    public CandidateConversionResponse(List<Field> fields, List<Company> companies) {
        this.fields = fields;
        this.companies = companies;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
