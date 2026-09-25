import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Ponyai006Tests extends AbstractOjTests {
    public Ponyai006Tests() {
        super("/ponyai/006/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        Ponyai006.main(null);
        super.doAssertion(OUTPUT1);
    }
}
