package p1841;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1841ETests extends AbstractOjTests {
    public CF1841ETests() {
        super("/p1841/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1841E.main(null);
        super.doAssertion();
    }
}