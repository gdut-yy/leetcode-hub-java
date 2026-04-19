package p2098;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2098BTests extends AbstractOjTests {
    public CF2098BTests() {
        super("/p2098/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2098B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
