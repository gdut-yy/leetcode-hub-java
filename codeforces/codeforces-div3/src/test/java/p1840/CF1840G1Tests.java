package p1840;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1840G1Tests extends AbstractOjTests {
    public CF1840G1Tests() {
        super("/p1840/G1/");
    }

    @Test
    @Disabled("交互题")
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1840G1.main(null);
        super.doAssertion();
    }
}