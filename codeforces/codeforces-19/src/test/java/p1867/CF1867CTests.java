package p1867;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1867CTests extends AbstractOjTests {
    public CF1867CTests() {
        super("/p1867/C/");
    }

    @Test
    @Disabled("交互题")
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1867C.main(null);
        super.doAssertion();
    }
}