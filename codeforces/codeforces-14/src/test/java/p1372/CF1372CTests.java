package p1372;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1372CTests extends AbstractOjTests {
    public CF1372CTests() {
        super("/p1372/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1372C.main(null);
        super.doAssertion(OUTPUT1);
    }
}