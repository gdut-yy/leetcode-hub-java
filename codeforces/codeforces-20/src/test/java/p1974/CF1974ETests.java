package p1974;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1974ETests extends AbstractOjTests {
    public CF1974ETests() {
        super("/p1974/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1974E.main(null);
        super.doAssertion(OUTPUT1);
    }
}