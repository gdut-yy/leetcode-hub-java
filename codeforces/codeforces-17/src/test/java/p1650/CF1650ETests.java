package p1650;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1650ETests extends AbstractOjTests {
    public CF1650ETests() {
        super("/p1650/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1650E.main(null);
        super.doAssertion();
    }
}