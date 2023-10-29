package p1878;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1878ETests extends AbstractOjTests {
    public CF1878ETests() {
        super("/p1878/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1878E.main(null);
        super.doAssertion();
    }
}