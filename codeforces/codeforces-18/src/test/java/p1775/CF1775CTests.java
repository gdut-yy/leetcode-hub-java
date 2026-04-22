package p1775;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1775CTests extends AbstractOjTests {
    public CF1775CTests() {
        super("/p1775/C/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1775C.main(null);
        super.doAssertion(OUTPUT1);
    }
}