package p1831;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1831DTests extends AbstractOjTests {
    public CF1831DTests() {
        super("/p1831/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1831D.main(null);
        super.doAssertion();
    }
}