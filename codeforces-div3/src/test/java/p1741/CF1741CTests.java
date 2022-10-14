package p1741;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1741CTests extends AbstractOjTests {
    public CF1741CTests() {
        super("/p1741/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1741C.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1741C.main(null);
        super.doAssertion(OUTPUT2);
    }
}
