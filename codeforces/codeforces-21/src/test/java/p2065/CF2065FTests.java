package p2065;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2065FTests extends AbstractOjTests {
    public CF2065FTests() {
        super("/p2065/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2065F.main(null);
        super.doAssertion(OUTPUT1);
    }
}