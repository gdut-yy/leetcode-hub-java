package p1873;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1873ETests extends AbstractOjTests {
    public CF1873ETests() {
        super("/p1873/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1873E.main(null);
        super.doAssertion();
    }
}