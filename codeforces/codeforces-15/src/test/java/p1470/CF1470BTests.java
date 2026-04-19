package p1470;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1470BTests extends AbstractOjTests {
    public CF1470BTests() {
        super("/p1470/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1470B.main(null);
        super.doAssertion(OUTPUT1);
    }
}