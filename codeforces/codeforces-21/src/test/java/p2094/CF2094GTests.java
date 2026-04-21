package p2094;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2094GTests extends AbstractOjTests {
    public CF2094GTests() {
        super("/p2094/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2094G.main(null);
        super.doAssertion(OUTPUT1);
    }
}