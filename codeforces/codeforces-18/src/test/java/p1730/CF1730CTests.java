package p1730;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1730CTests extends AbstractOjTests {
    public CF1730CTests() {
        super("/p1730/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1730C.main(null);
        super.doAssertion(OUTPUT1);
    }
}