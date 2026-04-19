package p1864;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1864DTests extends AbstractOjTests {
    public CF1864DTests() {
        super("/p1864/D/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1864D.main(null);
        super.doAssertion(OUTPUT1);
    }
}