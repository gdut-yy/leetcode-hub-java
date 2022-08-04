package p1714;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1714ATests extends AbstractOjTests {
    public CF1714ATests() {
        super("/p1714/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1714A.main(null);
        super.doAssertion();
    }
}
