package p1494;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1494CTests extends AbstractOjTests {
    public CF1494CTests() {
        super("/p1494/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1494C.main(null);
        super.doAssertion(OUTPUT1);
    }
}