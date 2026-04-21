package p1789;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1789CTests extends AbstractOjTests {
    public CF1789CTests() {
        super("/p1789/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1789C.main(null);
        super.doAssertion(OUTPUT1);
    }
}