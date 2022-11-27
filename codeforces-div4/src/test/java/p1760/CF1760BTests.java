package p1760;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1760BTests extends AbstractOjTests {
    public CF1760BTests() {
        super("/p1760/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1760B.main(null);
        super.doAssertion();
    }
}
