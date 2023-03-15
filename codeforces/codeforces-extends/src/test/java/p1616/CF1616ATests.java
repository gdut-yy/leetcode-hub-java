package p1616;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1616ATests extends AbstractOjTests {
    public CF1616ATests() {
        super("/p1616/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1616A.main(null);
        super.doAssertion();
    }
}
