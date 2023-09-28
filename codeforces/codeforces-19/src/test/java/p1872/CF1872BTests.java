package p1872;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1872BTests extends AbstractOjTests {
    public CF1872BTests() {
        super("/p1872/B/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1872B.main(null);
        super.doAssertion();
    }
}