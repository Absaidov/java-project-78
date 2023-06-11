package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.App.hello;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest2 {
    @Test
    public void testApp() {
        String expected = "Hello World! LOL";
        assertEquals(expected, hello());
    }
    @Test
    public void testApp2() {
        String expected = "Hello World! LOL";
        assertEquals(expected, hello());
    }
}
