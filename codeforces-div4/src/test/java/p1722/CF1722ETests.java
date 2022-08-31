package p1722;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1722ETests extends AbstractOjTests {
    public CF1722ETests() {
        super("/p1722/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1722E.main(null);
        super.doAssertion();
    }
}
