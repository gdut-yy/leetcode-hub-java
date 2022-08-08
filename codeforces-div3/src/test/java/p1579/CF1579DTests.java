package p1579;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1579DTests extends AbstractOjTests {
    public CF1579DTests() {
        super("/p1579/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1579A.main(null);
        super.doAssertion();
    }
}
