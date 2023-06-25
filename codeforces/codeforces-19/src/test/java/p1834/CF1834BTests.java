package p1834;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1834BTests extends AbstractOjTests {
    public CF1834BTests() {
        super("/p1834/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1834B.main(null);
        super.doAssertion();
    }
}