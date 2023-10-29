package p1881;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1881ATests extends AbstractOjTests {
    public CF1881ATests() {
        super("/p1881/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1881A.main(null);
        super.doAssertion();
    }
}