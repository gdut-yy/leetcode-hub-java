package p1846;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1846BTests extends AbstractOjTests {
    public CF1846BTests() {
        super("/p1846/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1846B.main(null);
        super.doAssertion();
    }
}