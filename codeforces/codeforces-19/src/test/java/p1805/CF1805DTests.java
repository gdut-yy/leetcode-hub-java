package p1805;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1805DTests extends AbstractOjTests {
    public CF1805DTests() {
        super("/p1805/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1805D.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1805D.main(null);
        super.doAssertion(OUTPUT2);
    }
}
