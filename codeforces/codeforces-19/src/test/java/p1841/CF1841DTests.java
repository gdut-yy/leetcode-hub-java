package p1841;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1841DTests extends AbstractOjTests {
    public CF1841DTests() {
        super("/p1841/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1841D.main(null);
        super.doAssertion();
    }
}