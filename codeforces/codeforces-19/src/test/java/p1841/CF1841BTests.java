package p1841;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1841BTests extends AbstractOjTests {
    public CF1841BTests() {
        super("/p1841/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1841B.main(null);
        super.doAssertion();
    }
}