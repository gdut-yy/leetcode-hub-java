package p1842;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1842ATests extends AbstractOjTests {
    public CF1842ATests() {
        super("/p1842/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1842A.main(null);
        super.doAssertion();
    }
}