package p1619;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1619ETests extends AbstractOjTests {
    public CF1619ETests() {
        super("/p1619/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1619E.main(null);
        super.doAssertion();
    }
}
