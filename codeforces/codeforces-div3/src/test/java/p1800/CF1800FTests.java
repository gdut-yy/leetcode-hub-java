package p1800;

import base.AbstractOjTests;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1800FTests extends AbstractOjTests {
    public CF1800FTests() {
        super("/p1800/F/");
    }

    @Test
    @Disabled
    public void example1() throws IOException {
        super.doSetSystemInOut();
        CF1800F.main(null);
        // java.lang.OutOfMemoryError: Java heap space
        super.doAssertion();
    }
}
