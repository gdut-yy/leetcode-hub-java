package p1458;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class CF1458ATests extends AbstractOjTests {
    public CF1458ATests() {
        super("/p1458/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1458A.main(null);
        super.doAssertion(OUTPUT1);
    }
}
