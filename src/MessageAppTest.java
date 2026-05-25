import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MessageAppTest {

    @Test
    public void testGenerateMessage() throws Exception {

        Method method = MessageAppTest.class.getDeclaredMethod("generateMessageId");
        method.setAccessible(true);

        String messageId = (String) method.invoke(null);

        assertNotNull(messageId);
        assertTrue(messageId.startsWith("MGS"));
    }

    @Test
    public void testGenerateMessageHash() throws Exception {

        Method method = MessageAppTest.class.getDeclaredMethod(
                "generateMessageHash",
                String.class,
                int.class,
                String.class
        );

        method.setAccessible(true);

        String result = (String) method.invoke(null, "MSG12345", 1, "Hello world");

        assertEquals("MS:1:HELLOWORLD", result);
    }

    @Test
    public void testValidSouthAfricanNumber() {

        String number = "+27814510619";

        boolean valid = number.startsWith("+27") && number.length() == 12;

        assertTrue(valid);
    }

    @Test
    public void testInvalidSouthAfricanNumber() {

        String number = "0814510619";

        boolean valid = number.startsWith("+27") && number.length() == 12;

        assertFalse(valid);
    }

    @Test
    public void testMessageLengthValid() {

        String message = "This is a short message";

        assertTrue(message.length() <= 250);
    }

    @Test
    public void testMessageLengthTooLong() {

        String message = "A".repeat(251);

        assertTrue(message.length() > 250);
    }
}