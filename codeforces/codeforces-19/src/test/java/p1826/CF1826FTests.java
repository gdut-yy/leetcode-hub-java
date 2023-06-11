package p1826;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1826FTests extends AbstractOjTests {
    public CF1826FTests() {
        super("/p1826/F/");
    }

    @Test
    @Disabled("交互题")
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1826A.main(null);
        super.doAssertion();
    }
}