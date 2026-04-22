package p1996;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1996DTests extends AbstractOjTests {
    public CF1996DTests() {
        super("/p1996/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1996D.main(null);
        super.doAssertion(OUTPUT1);
    }
}