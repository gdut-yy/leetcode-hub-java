package p1831;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1831ETests extends AbstractOjTests {
    public CF1831ETests() {
        super("/p1831/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1831E.main(null);
        super.doAssertion();
    }
}