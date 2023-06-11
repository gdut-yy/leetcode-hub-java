package p1628;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1628BTests extends AbstractOjTests {
    public CF1628BTests() {
        super("/p1628/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1628B.main(null);
        super.doAssertion();
    }
}