package p2137;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2137ETests extends AbstractOjTests {
    public CF2137ETests() {
        super("/p2137/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2137E.main(null);
        super.doAssertion(OUTPUT1);
    }
}