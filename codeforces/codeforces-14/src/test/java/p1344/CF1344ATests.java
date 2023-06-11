package p1344;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1344ATests extends AbstractOjTests {
    public CF1344ATests() {
        super("/p1344/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1344A.main(null);
        super.doAssertion();
    }
}