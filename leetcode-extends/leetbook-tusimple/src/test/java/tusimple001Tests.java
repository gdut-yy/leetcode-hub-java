import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class tusimple001Tests extends AbstractOjTests {
    public tusimple001Tests() {
        super("/tusimple/001/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        tusimple001.main(null);
        super.doAssertion(OUTPUT1);
    }
}
