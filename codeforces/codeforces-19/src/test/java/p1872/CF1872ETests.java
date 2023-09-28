package p1872;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1872ETests extends AbstractOjTests {
    public CF1872ETests() {
        super("/p1872/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1872E.main(null);
        super.doAssertion();
    }
}