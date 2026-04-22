package p1870;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1870DTests extends AbstractOjTests {
    public CF1870DTests() {
        super("/p1870/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1870D.main(null);
        super.doAssertion(OUTPUT1);
    }
}