package p1766;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1766DTests extends AbstractOjTests {
    public CF1766DTests() {
        super("/p1766/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1766D.main(null);
        super.doAssertion(OUTPUT1);
    }
}