package p1469;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1469ETests extends AbstractOjTests {
    public CF1469ETests() {
        super("/p1469/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1469E.main(null);
        super.doAssertion();
    }
}