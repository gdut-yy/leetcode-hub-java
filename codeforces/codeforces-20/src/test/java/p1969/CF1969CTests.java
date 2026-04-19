package p1969;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1969CTests extends AbstractOjTests {
    public CF1969CTests() {
        super("/p1969/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1969C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
