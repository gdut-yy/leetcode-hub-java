package p526;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF526ETests extends AbstractOjTests {
    public CF526ETests() {
        super("/p526/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF526E.main(null);
        super.doAssertion(OUTPUT1);
    }
}