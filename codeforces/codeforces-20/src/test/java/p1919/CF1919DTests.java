package p1919;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1919DTests extends AbstractOjTests {
    public CF1919DTests() {
        super("/p1919/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1919D.main(null);
        super.doAssertion(OUTPUT1);
    }
}