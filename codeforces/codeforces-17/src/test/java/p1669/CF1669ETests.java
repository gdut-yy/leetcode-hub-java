package p1669;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1669ETests extends AbstractOjTests {
    public CF1669ETests() {
        super("/p1669/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1669E.main(null);
        super.doAssertion();
    }
}
