package p1759;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1759ETests extends AbstractOjTests {
    public CF1759ETests() {
        super("/p1759/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1759E.main(null);
        super.doAssertion();
    }
}
