package p1907;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1907CTests extends AbstractOjTests {
    public CF1907CTests() {
        super("/p1907/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1907C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
