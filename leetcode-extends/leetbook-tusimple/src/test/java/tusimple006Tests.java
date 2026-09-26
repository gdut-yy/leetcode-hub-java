import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class tusimple006Tests extends AbstractOjTests {
    public tusimple006Tests() {
        super("/tusimple/006/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        tusimple006.main(null);
        super.doAssertion(OUTPUT1);
    }
}
