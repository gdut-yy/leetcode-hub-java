package p1935;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1935CTests extends AbstractOjTests {
    public CF1935CTests() {
        super("/p1935/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1935C.main(null);
        super.doAssertion(OUTPUT1);
    }
}