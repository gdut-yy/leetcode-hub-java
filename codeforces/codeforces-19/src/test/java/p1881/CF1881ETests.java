package p1881;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1881ETests extends AbstractOjTests {
    public CF1881ETests() {
        super("/p1881/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1881E.main(null);
        super.doAssertion();
    }
}