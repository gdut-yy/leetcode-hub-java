package p1828;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1828BTests extends AbstractOjTests {
    public CF1828BTests() {
        super("/p1828/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1828B.main(null);
        super.doAssertion();
    }
}