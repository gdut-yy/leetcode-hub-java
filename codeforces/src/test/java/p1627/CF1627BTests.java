package p1627;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1627BTests extends AbstractOjTests {
    public CF1627BTests() {
        super("/p1627/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1627B.main(null);
        super.doAssertion();
    }
}
