package p1796;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1796DTests extends AbstractOjTests {
    public CF1796DTests() {
        super("/p1796/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1796D.main(null);
        super.doAssertion(OUTPUT1);
    }
}