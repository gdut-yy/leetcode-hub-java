package p1851;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1851DTests extends AbstractOjTests {
    public CF1851DTests() {
        super("/p1851/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1851D.main(null);
        super.doAssertion();
    }
}