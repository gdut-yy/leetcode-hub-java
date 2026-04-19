package p1821;

import base.AbstractOjTests;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CF1821ETests extends AbstractOjTests {
    public CF1821ETests() {
        super("/p1821/E/");
    }

    @Test
    public void example1() throws IOException {
        super.doSetSystemInOut(INPUT1);
        CF1821E.main(null);
        super.doAssertion(OUTPUT1);
    }
}