package workamerica.contexts.gateways.website.conversion.models.employers;

import workamerica.contexts.reporting.models.shared.DeviceLogs;

import java.util.ArrayList;

/**
 * Created by Faizan on 8/15/2016.
 */
public class EmployerCreateRequest {

    private String firstName;
    private String lastName;
    private String company;
    private String phone;
    private String email;
    private String password;
    private String categories;
    private ArrayList<Integer> fields;
    private String zip;
    private DeviceLogs device;

    public EmployerCreateRequest () {}

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public ArrayList<Integer> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Integer> fields) {
        this.fields = fields;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public DeviceLogs getDevice() {
        return device;
    }

    public void setDevice(DeviceLogs device) {
        this.device = device;
    }

}
