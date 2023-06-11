package p1833;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1833FTests extends AbstractOjTests {
    public CF1833FTests() {
        super("/p1833/F/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1833F.main(null);
        super.doAssertion();
    }
}