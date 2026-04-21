package p2069;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF2069BTests extends AbstractOjTests {
    public CF2069BTests() {
        super("/p2069/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF2069B.main(null);
        super.doAssertion(OUTPUT1);
    }
}