import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class tusimple002Tests extends AbstractOjTests {
    public tusimple002Tests() {
        super("/tusimple/002/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        tusimple002.main(null);
        super.doAssertion(OUTPUT1);
    }
}
