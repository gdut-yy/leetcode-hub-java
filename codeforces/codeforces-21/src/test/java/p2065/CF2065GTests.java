package p2065;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2065GTests extends AbstractOjTests {
    public CF2065GTests() {
        super("/p2065/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2065G.main(null);
        super.doAssertion(OUTPUT1);
    }
}