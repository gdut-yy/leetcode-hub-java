package p1623;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1623ATests extends AbstractOjTests {
    public CF1623ATests() {
        super("/p1623/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1623A.main(null);
        super.doAssertion();
    }
}
