package p2116;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF2116BTests extends AbstractOjTests {
    public CF2116BTests() {
        super("/p2116/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2116B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
