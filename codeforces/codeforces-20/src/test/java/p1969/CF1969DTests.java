package p1969;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1969DTests extends AbstractOjTests {
    public CF1969DTests() {
        super("/p1969/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1969D.main(null);
        super.doAssertion(OUTPUT1);
    }
}