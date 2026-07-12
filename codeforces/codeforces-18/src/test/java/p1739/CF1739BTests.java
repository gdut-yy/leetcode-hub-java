package p1739;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1739BTests extends AbstractOjTests {
    public CF1739BTests() {
        super("/p1739/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1739B.main(null);
        super.doAssertion(OUTPUT1);
    }
}
