package p1926;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1926GTests extends AbstractOjTests {
    public CF1926GTests() {
        super("/p1926/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1926G.main(null);
        super.doAssertion(OUTPUT1);
    }
}