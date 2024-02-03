package p1914;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1914E2Tests extends AbstractOjTests {
    public CF1914E2Tests() {
        super("/p1914/E2/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1914E2.main(null);
        super.doAssertion(OUTPUT1);
    }
}