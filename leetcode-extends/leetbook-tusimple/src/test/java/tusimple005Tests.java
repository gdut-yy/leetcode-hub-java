import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class tusimple005Tests extends AbstractOjTests {
    public tusimple005Tests() {
        super("/tusimple/005/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        tusimple005.main(null);
        super.doAssertion(OUTPUT1);
    }
}
