package p1875;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1875DTests extends AbstractOjTests {
    public CF1875DTests() {
        super("/p1875/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1875D.main(null);
        super.doAssertion(OUTPUT1);
    }
}