package workamerica.contexts.companies.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Faizan on 8/5/2016.
 */
@Entity
@Table(name = "Companies", schema = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompanyID")
    private Long companyID;
    @Column(name = "Name")
    private String name;
    @Column(name = "ViewLimit")
    @JsonIgnore
    private Integer viewLimit;
    @Column(name = "Picture")
    private String picture;
    @Column(name = "Categories")
    @JsonIgnore
    private String categories;
    @JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<CompanyAccount> accounts = new ArrayList<CompanyAccount>();

    public Company () {}

    public Company (String name, String categories) {
        this.name = name;
        this.categories = categories;
        this.picture = "";
        this.viewLimit = 0;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Company company;
            if (obj == null || (company = ((Company) obj)).getCompanyID() <= 0) {
                return false;
            } else {
                return (this.companyID == company.getCompanyID());
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.companyID);
    }

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getViewLimit() {
        return viewLimit;
    }

    public void setViewLimit(Integer viewLimit) {
        this.viewLimit = viewLimit;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public List<CompanyAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<CompanyAccount> accounts) {
        this.accounts = accounts;
    }
}
