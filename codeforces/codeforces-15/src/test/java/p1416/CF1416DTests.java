package p1416;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1416DTests extends AbstractOjTests {
    public CF1416DTests() {
        super("/p1416/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1416D.main(null);
        super.doAssertion(OUTPUT1);
    }
}