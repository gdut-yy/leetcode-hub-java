package p1931;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1931DTests extends AbstractOjTests {
    public CF1931DTests() {
        super("/p1931/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1931D.main(null);
        super.doAssertion(OUTPUT1);
    }
}