package p1734;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1734ATests extends AbstractOjTests {
    public CF1734ATests() {
        super("/p1734/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1734A.main(null);
        super.doAssertion();
    }
}