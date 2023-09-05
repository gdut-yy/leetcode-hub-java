package p1849;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1849BTests extends AbstractOjTests {
    public CF1849BTests() {
        super("/p1849/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1849B.main(null);
        super.doAssertion();
    }
}