package p1822;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1822DTests extends AbstractOjTests {
    public CF1822DTests() {
        super("/p1822/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1822D.main(null);
        super.doAssertion();
    }
}