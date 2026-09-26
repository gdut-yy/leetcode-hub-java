import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class tusimple003Tests extends AbstractOjTests {
    public tusimple003Tests() {
        super("/tusimple/003/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        tusimple003.main(null);
        super.doAssertion(OUTPUT1);
    }
}
