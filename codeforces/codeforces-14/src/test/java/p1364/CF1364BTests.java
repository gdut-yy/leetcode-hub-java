package p1364;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1364BTests extends AbstractOjTests {
    public CF1364BTests() {
        super("/p1364/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1364B.main(null);
        super.doAssertion(OUTPUT1);
    }
}