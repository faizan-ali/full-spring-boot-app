package workamerica.contexts.gateways.website.conversion.models.candidates;

import workamerica.contexts.reporting.models.shared.DeviceLogs;
import workamerica.contexts.utilities.StringUtilities;

import java.util.ArrayList;

/**
 * Created by Faizan on 8/5/2016.
 */
public class CandidateConversionRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long fieldID;
    private String zip;
    private ArrayList<Long> interests;
    private DeviceLogs device;

    public CandidateConversionRequest() {}

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

    public Long getFieldID() {
        return fieldID;
    }

    public void setFieldID(Long fieldID) {
        this.fieldID = fieldID;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public ArrayList<Long> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<Long> interests) {
        this.interests = interests;
    }

    public boolean isValid () {
        if (firstName == null || lastName == null || !StringUtilities.isValidEmail(email) || password == null ||
               interests == null || zip == null || fieldID <= 0) {
            return false;
        }

        return true;
    }

    public DeviceLogs getDevice() {
        return device;
    }

    public void setDevice(DeviceLogs device) {
        this.device = device;
    }
}
