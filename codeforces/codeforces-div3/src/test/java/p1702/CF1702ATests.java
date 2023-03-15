package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702ATests extends AbstractOjTests {
    public CF1702ATests() {
        super("/p1702/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702A.main(null);
        super.doAssertion();
    }
}
