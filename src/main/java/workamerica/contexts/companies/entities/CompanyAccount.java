package workamerica.contexts.companies.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import workamerica.contexts.candidates.models.CustomConverter;
import workamerica.contexts.utilities.Clock;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Faizan on 8/5/2016.
 */
@Entity
@Table(name = "CompanyAccounts", schema = "Company")
public class CompanyAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CompanyAccountID")
    private Long companyAccountID;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @JsonIgnore
    @Column(name = "Password")
    private String password;
    @JsonIgnore
    @Column(name = "Salt")
    private String salt;
    @JsonIgnore
    @Column(name = "Phone")
    private String phone;
    @JsonIgnore
    @Column(name = "Zip")
    private String zip;
    @JsonIgnore
    @Column(name = "ProfilesViewed")
    private int profilesViewed;
    @JsonIgnore
    @Column(name = "ProfilesViewedThisMonth")
    private int profilesViewedThisMonth;
    @Column(name = "Approved")
    @JsonIgnore
    private String approved;
    @Column(name = "DateCreated")
    @JsonIgnore
    private String dateCreated;
    @Column(name = "TimeCreated")
    @JsonIgnore
    private String timeCreated;
    @Column(name = "StripeID")
    @JsonIgnore
    private String stripeID;
    @JsonIgnore
    @Column(name = "InterestFields")
    @Convert(converter = CustomConverter.class)
    private ArrayList<Integer> fields;
    @JsonIgnore
    @Column(name = "CompanyID")
    private Long companyID;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CompanyID", referencedColumnName = "CompanyID", insertable = false, updatable = false)
    private Company company;

    public CompanyAccount () {}

    public CompanyAccount(String firstName, String lastName, String phone, String email, String password, String salt, String zip, Long companyID, ArrayList<Integer> fields) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.zip = zip;
        this.companyID = companyID;
        this.fields = fields;
        this.dateCreated = Clock.currentDate();
        this.timeCreated = Clock.currentTime();
    }

    @Override
    public boolean equals(Object obj) {
        try {
            CompanyAccount account;
            if (obj == null || (account = ((CompanyAccount) obj)).getCompanyAccountID() <= 0) {
                return false;
            } else {
                return (this.companyID == account.getCompanyAccountID());
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.companyID);
    }

    public Long getCompanyAccountID() {
        return companyAccountID;
    }

    public void setCompanyAccountID(Long companyAccountID) {
        this.companyAccountID = companyAccountID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getProfilesViewed() {
        return profilesViewed;
    }

    public void setProfilesViewed(int profilesViewed) {
        this.profilesViewed = profilesViewed;
    }

    public int getProfilesViewedThisMonth() {
        return profilesViewedThisMonth;
    }

    public void setProfilesViewedThisMonth(int profilesViewedThisMonth) {
        this.profilesViewedThisMonth = profilesViewedThisMonth;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<Integer> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Integer> fields) {
        this.fields = fields;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getStripeID() {
        return stripeID;
    }

    public void setStripeID(String stripeID) {
        this.stripeID = stripeID;
    }
}
