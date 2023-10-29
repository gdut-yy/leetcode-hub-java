package p1878;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1878DTests extends AbstractOjTests {
    public CF1878DTests() {
        super("/p1878/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1878D.main(null);
        super.doAssertion();
    }
}