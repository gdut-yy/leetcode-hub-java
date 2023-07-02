package p609;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF609ETests extends AbstractOjTests {
    public CF609ETests() {
        super("/p609/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF609E.main(null);
        super.doAssertion();
    }
}