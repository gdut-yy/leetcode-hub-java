package p1702;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1702ETests extends AbstractOjTests {
    public CF1702ETests() {
        super("/p1702/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1702E.main(null);
        super.doAssertion();
    }
}
