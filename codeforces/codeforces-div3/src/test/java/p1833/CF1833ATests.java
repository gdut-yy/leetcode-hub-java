package p1833;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1833ATests extends AbstractOjTests {
    public CF1833ATests() {
        super("/p1833/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1833A.main(null);
        super.doAssertion();
    }
}