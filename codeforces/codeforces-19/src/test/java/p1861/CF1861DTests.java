package p1861;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1861DTests extends AbstractOjTests {
    public CF1861DTests() {
        super("/p1861/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1861D.main(null);
        super.doAssertion();
    }
}