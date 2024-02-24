package p1665;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1665ETests extends AbstractOjTests {
    public CF1665ETests() {
        super("/p1665/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1665E.main(null);
        super.doAssertion();
    }
}