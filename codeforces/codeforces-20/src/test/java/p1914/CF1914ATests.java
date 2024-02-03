package p1914;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1914ATests extends AbstractOjTests {
    public CF1914ATests() {
        super("/p1914/A/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1914A.main(null);
        super.doAssertion(OUTPUT1);
    }
}