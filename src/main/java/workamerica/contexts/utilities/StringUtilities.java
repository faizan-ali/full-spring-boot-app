package workamerica.contexts.utilities;

/**
 * Created by Faizan on 8/5/2016.
 */
public class StringUtilities {
    // Checks if an sendgrid contains an '@' and a '.'
    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    // Takes a phone number and returns it without any non-numeric characters or whitespace
    public static String cleanNumber(String phone) {
        return phone == null ? "" : phone.trim().replaceAll("[^0-9]+", "");
    }

    // Checks if a phone number's length is 10 after stripping non-numeric characters
    public static boolean isValidNumber(String phone) {
        return cleanNumber(phone).length() == 10;
    }

    // Checks if username is e-mail or phone
    public static boolean isValidUserName(String userName) {
        return isValidEmail(userName) || isValidNumber(userName);
    }

    // Returns a new String with the first letter of the parameter capitalized
    public static String capitalizeFirstLetter(String word) {
        return word != null && word.length() > 1 ?  (word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).trim() : "";
    }

    // Checks if a string is purely numeric
    public static boolean isNumeric(String string) {
        return string != null && string.matches("^\\d+$");
    }

    // Checks if a Zip is numeric and length is 5
    public static boolean isValidZip(String zip) {
        return zip != null && zip.length() == 5 && isNumeric(zip);
    }
}