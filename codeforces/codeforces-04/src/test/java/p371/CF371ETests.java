package p371;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF371ETests extends AbstractOjTests {
    public CF371ETests() {
        super("/p371/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF371E.main(null);
        super.doAssertion(OUTPUT1);
    }
}