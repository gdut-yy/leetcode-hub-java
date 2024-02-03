package p1921;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1921CTests extends AbstractOjTests {
    public CF1921CTests() {
        super("/p1921/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1921C.main(null);
        super.doAssertion(OUTPUT1);
    }
}
