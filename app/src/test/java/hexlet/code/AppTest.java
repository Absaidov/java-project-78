package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.App.hello;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void AppTest() {
        String expected = "Hello World! LOL";
        assertEquals(expected,hello());
    }
}
