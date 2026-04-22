package p1884;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1884DTests extends AbstractOjTests {
    public CF1884DTests() {
        super("/p1884/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1884D.main(null);
        super.doAssertion(OUTPUT1);
    }
}