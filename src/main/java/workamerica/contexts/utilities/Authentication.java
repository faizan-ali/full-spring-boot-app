package workamerica.contexts.utilities;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;

/**
 * Created by Faizan on 8/18/2016.
 */
public class Authentication {

    // Helper method to check if a given password matches one stored using the stored salt
    public static boolean isValid(String givenPassword, String storedPassword, String salt) {
        if (givenPassword != null && storedPassword != null) {
            return hashPassword(givenPassword, hexToBytes(salt))[0].equals(storedPassword);
        }
        return false;
    }

    // Essentially a helper method to hash a password for a new user and return a password + salt in an array
    public static String[] hashPassword(String password) {
        if (password != null) {
            return hashPassword(password, null);
        }
        return new String[]{"", ""};
    }

    // Takes a String password and a Byte Array representing a salt (which can
    // be null)
    // If the salt is null, generates a new salt to hash the password, otherwise
    // uses parameter salt
    // Returns a String Array where [0] is the hashed password and [1] is the
    // salt
    private static String[] hashPassword(final String passwordString, byte[] saltBytes) {

        // Number of iterations for PBKDF2 algorithm execution
        final int iterations = 1000;

        final int keyLength = 256;

        // Byte array representing hashed password
        byte[] hashBytes;

        // Array returns hashed password in [0] and salt in [1];
        String[] passwordArray = new String[2];

        // Initializes a CSPRNG
        SecureRandom random = new SecureRandom();

        // Byte array representing salt if parameter is null
        if (saltBytes == null) {
            saltBytes = new byte[32];
            random.nextBytes(saltBytes);
        }

        // Algorithm procured from https://www.owasp.org/index.php/Hashing_Java
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(passwordString.toCharArray(), saltBytes, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            hashBytes = key.getEncoded();
        } catch (Exception e) {
            e.printStackTrace();
            return new String[]{"", ""};
        }

        // Converting bytes to hexadecimal strings to return
        String password = bytesToHex(hashBytes);
        String salt = bytesToHex(saltBytes);

        passwordArray[0] = password;
        passwordArray[1] = salt;

        return passwordArray;
    }

    // Converts a Byte Array to a hexadecimal String, helper function for
    // hashPassword
    // Thanks Stackoverflow for an efficient as fuck solution
    private static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    // Converts a hexadecimal String to a Byte Array, used to compare hashed
    // password for authentication
    private static byte[] hexToBytes(String hex) {
        return DatatypeConverter.parseHexBinary(hex);
    }

    // Generates tokens that are valid till EOD
    private static String generateToken(String userAgent, String key) {
        if (userAgent != null && !userAgent.isEmpty() && key != null && !key.isEmpty()) {
            return (userAgent + Clock.currentDate() + key).hashCode() + "";
        }
        // TODO Really dude?
        return "ASDFASDF#@!@#$asd".hashCode() + "";
    }

    public static String generateEmployerToken(String userAgent) {
        String key = "This is a temporary employer key".hashCode() + "";
        return generateToken(userAgent, key);
    }

    public static String generateCandidateToken(String userAgent) {
        String key = "This is a temporary candidate key".hashCode() + "";
        return generateToken(userAgent, key);
    }

    public static boolean isValidEmployerToken(String token, String userAgent) {
        return token != null && token.equals(generateEmployerToken(userAgent));
    }

    public static boolean isValidCandidateToken(String token, String userAgent) {
        return token != null && token.equals(generateCandidateToken(userAgent));
    }

}
