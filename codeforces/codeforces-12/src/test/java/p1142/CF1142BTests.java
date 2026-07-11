package p1142;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1142BTests extends AbstractOjTests {
    public CF1142BTests() {
        super("/p1142/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1142B.main(null);
        super.doAssertion(OUTPUT1);
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1142B.main(null);
        super.doAssertion(OUTPUT2);
    }
}
