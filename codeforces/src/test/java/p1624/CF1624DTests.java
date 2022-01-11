package p1624;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1624DTests extends AbstractOjTests {
    public CF1624DTests() {
        super("/p1624/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1624D.main(null);
        super.doAssertion();
    }

    @Test
    public void example2() throws IOException {
        super.doSetSystemInOut(INPUT2);
        CF1624D.main(null);
        super.doAssertion(OUTPUT2);
    }
}
