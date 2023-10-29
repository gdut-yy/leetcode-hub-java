package p1861;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1861BTests extends AbstractOjTests {
    public CF1861BTests() {
        super("/p1861/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1861B.main(null);
        super.doAssertion();
    }
}