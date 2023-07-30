package p1613;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1613DTests extends AbstractOjTests {
    public CF1613DTests() {
        super("/p1613/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1613D.main(null);
        super.doAssertion();
    }
}