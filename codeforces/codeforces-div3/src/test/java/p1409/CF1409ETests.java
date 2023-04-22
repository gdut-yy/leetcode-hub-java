package p1409;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1409ETests extends AbstractOjTests {
    public CF1409ETests() {
        super("/p1409/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1409E.main(null);
        super.doAssertion();
    }
}