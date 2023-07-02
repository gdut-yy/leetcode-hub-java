package p1256;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1256DTests extends AbstractOjTests {
    public CF1256DTests() {
        super("/p1256/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1256D.main(null);
        super.doAssertion();
    }
}