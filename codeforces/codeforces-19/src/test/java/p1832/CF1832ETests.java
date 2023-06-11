package p1832;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1832ETests extends AbstractOjTests {
    public CF1832ETests() {
        super("/p1832/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1832E.main(null);
        super.doAssertion();
    }
}