package p1265;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1265BTests extends AbstractOjTests {
    public CF1265BTests() {
        super("/p1265/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1265B.main(null);
        super.doAssertion(OUTPUT1);
    }
}