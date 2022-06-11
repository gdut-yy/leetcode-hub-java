package p1690;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1690DTests extends AbstractOjTests {
    public CF1690DTests() {
        super("/p1690/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1690D.main(null);
        super.doAssertion();
    }
}
