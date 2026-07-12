package p2180;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2180CTests extends AbstractOjTests {
    public CF2180CTests() {
        super("/p2180/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2180C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
