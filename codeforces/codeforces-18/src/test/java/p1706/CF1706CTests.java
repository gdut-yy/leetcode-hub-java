package p1706;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1706CTests extends AbstractOjTests {
    public CF1706CTests() {
        super("/p1706/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1706C.main(null);
        super.doAssertion(OUTPUT1);
    }
}