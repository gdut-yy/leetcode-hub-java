package p1692;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1692BTests extends AbstractOjTests {
    public CF1692BTests() {
        super("/p1692/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1692B.main(null);
        super.doAssertion();
    }
}
