package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702BTests extends AbstractOjTests {
    public CF1702BTests() {
        super("/p1702/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702B.main(null);
        super.doAssertion();
    }
}
