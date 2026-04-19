package p1609;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1609ETests extends AbstractOjTests {
    public CF1609ETests() {
        super("/p1609/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1609E.main(null);
        super.doAssertion(OUTPUT1);
    }
}