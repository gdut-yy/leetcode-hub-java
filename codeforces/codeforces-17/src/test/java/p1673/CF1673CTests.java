package p1673;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1673CTests extends AbstractOjTests {
    public CF1673CTests() {
        super("/p1673/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1673C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
