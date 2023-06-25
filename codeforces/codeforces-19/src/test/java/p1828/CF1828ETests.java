package p1828;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1828ETests extends AbstractOjTests {
    public CF1828ETests() {
        super("/p1828/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1828E.main(null);
        super.doAssertion();
    }
}