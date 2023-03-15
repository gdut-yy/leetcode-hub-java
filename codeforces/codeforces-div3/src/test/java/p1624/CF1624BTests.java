package p1624;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1624BTests extends AbstractOjTests {
    public CF1624BTests() {
        super("/p1624/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1624B.main(null);
        super.doAssertion();
    }
}
