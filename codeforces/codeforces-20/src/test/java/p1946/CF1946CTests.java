package p1946;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1946CTests extends AbstractOjTests {
    public CF1946CTests() {
        super("/p1946/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1946C.main(null);
        super.doAssertion(OUTPUT1);
    }
}