package p1827;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1827DTests extends AbstractOjTests {
    public CF1827DTests() {
        super("/p1827/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1827D.main(null);
        super.doAssertion(OUTPUT1);
    }
}
