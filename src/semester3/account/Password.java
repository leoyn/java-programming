package semester3.account;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Password {
    private String password;

    private static String hash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if(password == null) return null;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes("UTF-8"));

        return Base64.getEncoder().encodeToString(hash);
    }

    public Password(String password) {
        try {
            this.password = hash(password);
        } catch(NoSuchAlgorithmException | UnsupportedEncodingException error) {
            // TODO: Handle error
        }
    }

    public boolean compareTo(Password password) {
        if(this.password == null) return password == null;
        return this.password.equals(password.toString());
    }

    public String toString() {
        return this.password;
    }
}