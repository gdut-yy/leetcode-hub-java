package p1703;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1703ETests extends AbstractOjTests {
    public CF1703ETests() {
        super("/p1703/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1703E.main(null);
        super.doAssertion();
    }
}
