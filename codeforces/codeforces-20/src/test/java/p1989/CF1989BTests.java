package p1989;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1989BTests extends AbstractOjTests {
    public CF1989BTests() {
        super("/p1989/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1989B.main(null);
        super.doAssertion(OUTPUT1);
    }
}