package p1650;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1650GTests extends AbstractOjTests {
    public CF1650GTests() {
        super("/p1650/G/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1650G.main(null);
        super.doAssertion(OUTPUT1);
    }
}