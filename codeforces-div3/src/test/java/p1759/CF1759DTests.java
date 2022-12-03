package p1759;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1759DTests extends AbstractOjTests {
    public CF1759DTests() {
        super("/p1759/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1759D.main(null);
        super.doAssertion();
    }
}
