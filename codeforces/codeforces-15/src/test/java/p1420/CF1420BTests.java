package p1420;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1420BTests extends AbstractOjTests {
    public CF1420BTests() {
        super("/p1420/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1420B.main(null);
        super.doAssertion(OUTPUT1);
    }
}