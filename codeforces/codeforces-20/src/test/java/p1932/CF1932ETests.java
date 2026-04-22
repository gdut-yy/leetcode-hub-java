package p1932;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1932ETests extends AbstractOjTests {
    public CF1932ETests() {
        super("/p1932/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1932E.main(null);
        super.doAssertion(OUTPUT1);
    }
}