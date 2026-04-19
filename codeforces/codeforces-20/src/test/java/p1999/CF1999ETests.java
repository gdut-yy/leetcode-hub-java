package p1999;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1999ETests extends AbstractOjTests {
    public CF1999ETests() {
        super("/p1999/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1999E.main(null);
        super.doAssertion(OUTPUT1);
    }
}