package p1850;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1850BTests extends AbstractOjTests {
    public CF1850BTests() {
        super("/p1850/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1850B.main(null);
        super.doAssertion();
    }
}