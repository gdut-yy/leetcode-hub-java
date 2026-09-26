import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class tusimple004Tests extends AbstractOjTests {
    public tusimple004Tests() {
        super("/tusimple/004/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        tusimple004.main(null);
        super.doAssertion(OUTPUT1);
    }
}
