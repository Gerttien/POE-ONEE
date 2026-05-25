
import org.junit.Test;
import static org.junit.Assert.*;

public class main {

    // Registration: username tests
    @Test
    public void testValidUserName() {
        REGISTRATION reg = new REGISTRATION();
        assertTrue(reg.checkUserName("abc_")); // valid: <= 5 chars and contains "_"
    }

    @Test
    public void testInvalidUserNameTooLong() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkUserName("abcdef_")); // too long
    }

    @Test
    public void testInvalidUserNameNoUnderscore() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkUserName("abcd")); // missing "_"
    }

    // Registration: Password tests
    @Test
    public void testInvalidPasswordNoUppercase() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkpassword("password1!")); // no uppercase
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkpassword("Password!")); // missing digit
    }

    @Test
    public void testInvalidPasswordNoSpecialCharacter() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkpassword("Password1")); // missing special char
    }

    // Registration: Phone number tests
    @Test
    public void testValidPhoneNumLocal() {
        REGISTRATION reg = new REGISTRATION();
        assertTrue(reg.checkphoneNumber("0814510618")); // starts with 0 + 9 digits
    }

    @Test
    public void testValidPhoneNumInternational() {
        REGISTRATION reg = new REGISTRATION();
        assertTrue(reg.checkphoneNumber("+27814510618")); // starts with +27 + 9 digits
    }

    @Test
    public void testInvalidPhoneNumTooShort() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkphoneNumber("54321")); // too short
    }

    @Test
    public void testInvalidPhoneNumWrongPrefix() {
        REGISTRATION reg = new REGISTRATION();
        assertFalse(reg.checkphoneNumber("814510619")); // wrong prefix
    }

    // Login: Successful login
    @Test
    public void testSuccessfulLogin() {
        LOGIN login = new LOGIN("user123_", "pass123", "Gert", "Ngo");
        String result = login.loginUser("user123_", "pass123");
        assertTrue(result.startsWith("Welcome Gert Ngo"));
    }

    // Login: Failed login
    @Test
    public void testFailedLogin() {
        LOGIN login = new LOGIN("user123_", "pass123", "Gert", "Ngo");
        String result = login.loginUser("user123", "wrongpass");
        assertTrue(result.startsWith("Invalid username or password"));
    }
}